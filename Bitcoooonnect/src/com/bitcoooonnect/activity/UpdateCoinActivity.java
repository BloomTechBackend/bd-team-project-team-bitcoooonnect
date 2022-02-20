package com.bitcoooonnect.activity;

import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.CoinDao;
import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.models.CoinModel;
import com.bitcoooonnect.models.requests.UpdateCoinRequest;
import com.bitcoooonnect.models.results.UpdateCoinResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateCoinActivity implements RequestHandler<UpdateCoinRequest,
        UpdateCoinResult> {
    private final CoinDao coinDao;
    
    @Inject
    public UpdateCoinActivity(CoinDao coinDao) {this.coinDao = coinDao;}
    
    @Override
    public UpdateCoinResult handleRequest(final UpdateCoinRequest updateCoinRequest,
                                          Context context) {


        List<String> requestedIds = new ArrayList<>();
        requestedIds.addAll(updateCoinRequest.getCoins().keySet());

        Map<String, List<Object>> coins = coinDao.getCoin(requestedIds);

        List<CoinModel> coinModels = new ArrayList<>();
        List<Coin> allCoins = new ArrayList<>();

        for(Object coin : coins.get("coins") ) {
            Double price =
                    updateCoinRequest.getCoins().get(((Coin) coin).getId());

            ((Coin) coin).setPrice(price);
            coinModels.add(new ModelConverter().toCoinModel((Coin) coin));
            allCoins.add((Coin) coin);
        }

        coinDao.saveCoins(allCoins);

        return UpdateCoinResult.builder()
                .withCoins(allCoins)
                .build();
    }
}
