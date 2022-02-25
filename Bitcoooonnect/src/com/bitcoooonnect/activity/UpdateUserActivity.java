package com.bitcoooonnect.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.dynamodb.CoinDao;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.exceptions.CoinNotFoundException;
import com.bitcoooonnect.exceptions.InvalidAttributeException;
import com.bitcoooonnect.models.requests.UpdateUserRequest;
import com.bitcoooonnect.models.results.UpdateUserResult;

import javax.inject.Inject;
import java.util.Map;

public class UpdateUserActivity implements RequestHandler<UpdateUserRequest, UpdateUserResult> {
    private final UserDao userDao;
    private final CoinDao coinDao;

    @Inject
    public UpdateUserActivity(UserDao userDao, CoinDao coinDao) {

        this.userDao = userDao;
        this.coinDao = coinDao;
    }

    @Override
    public UpdateUserResult handleRequest(final UpdateUserRequest updateUserRequest, Context context) {
        User user = userDao.getUser(updateUserRequest.getEmailId());
        Map<String, Double> coins = user.getCoins();

        Coin coin = coinDao.getOneCoin(updateUserRequest.getCoinId());
        if(coin == null) {
            throw new CoinNotFoundException("Coin does not exist in our database!");
        }

        if(updateUserRequest.getAmount() < 0 || updateUserRequest.getAmount() > Double.MAX_VALUE) {
            throw new InvalidAttributeException("Amount should not be negative or greater than Double max value!");
        }

        if(updateUserRequest.getAmount() == 0) {
            coins.remove(updateUserRequest.getCoinId());
        }
        else {
            coins.put(updateUserRequest.getCoinId(), updateUserRequest.getAmount());
            user.setCoins(coins);
        }
        userDao.saveUser(user);

        return UpdateUserResult.builder()
                .withCoinList(coins)
                .build();
    }
}
