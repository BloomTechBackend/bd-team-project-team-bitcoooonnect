package com.bitcoooonnect.activity;


import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.CoinDao;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.exceptions.InvalidAttributeException;
import com.bitcoooonnect.models.CoinModel;
import com.bitcoooonnect.models.UserModel;
import com.bitcoooonnect.models.requests.GetUserRequest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.bitcoooonnect.models.results.GetUserResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserActivity implements RequestHandler<GetUserRequest, GetUserResult> {
    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;
    private final CoinDao coinDao;

    @Inject
    public GetUserActivity(UserDao userDao, CoinDao coinDao) {
        this.userDao = userDao;
        this.coinDao = coinDao;
    }

    @Override
    public GetUserResult handleRequest(final GetUserRequest getUserRequest, Context context) {
//        log.info("Received CreateUserRequest {}", CreateUserRequest);

        User user = userDao.getUser(getUserRequest.getEmailId());

        Map<String, Map<String, Double>> coinList = new HashMap<>();

        List<String> ids = new ArrayList<>();

        for(String userCoin : user.getCoins().keySet()) {
            ids.add(userCoin);
        }

        Map<String, List<Object>> userCoins = coinDao.getCoins(ids);

        for(Object object : userCoins.get("coins") ) {

            Coin coin = (Coin) object;

            Map<String, Double> coinDetails = new HashMap<>();

            String coinId = coin.getId();

            Double amount = user.getCoins().get(coinId);
            Double price = coin.getPrice();
            Double value = amount * price;
            coinDetails.put("price", price );
            coinDetails.put("amount", amount );
            coinDetails.put("value", value );



            coinList.put( coinId, coinDetails);
        }

        if(user == null) {
            throw new InvalidAttributeException("Invalid email, no user exists with that email address!");
        }

        UserModel userModel =  new ModelConverter().toUserModel(user);

        return GetUserResult.builder()
                .withUser(userModel)
                .withCoins(coinList)
                .build();
    }
}