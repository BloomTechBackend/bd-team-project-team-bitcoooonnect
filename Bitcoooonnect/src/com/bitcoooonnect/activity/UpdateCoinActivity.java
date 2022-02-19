package com.bitcoooonnect.activity;

import com.bitcoooonnect.dynamodb.CoinDao;
import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.models.requests.UpdateCoinRequest;
import com.bitcoooonnect.models.results.UpdateCoinResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import javax.inject.Inject;

import static java.lang.Double.valueOf;

public class UpdateCoinActivity implements RequestHandler<UpdateCoinRequest,
        UpdateCoinResult> {
    private final CoinDao coinDao;
    
    @Inject
    public UpdateCoinActivity(CoinDao coinDao) {this.coinDao = coinDao;}
    
    @Override
    public UpdateCoinResult handleRequest(UpdateCoinRequest updateCoinRequest,
                                          Context context) {
        Coin coin = coinDao.getCoin(updateCoinRequest.getId());

        coin.setPrice(updateCoinRequest.getPrice());

        coinDao.saveCoin(coin);

        return UpdateCoinResult.builder()
                .withId(coin.getId())
                .withPrice(coin.getPrice())
                .withName(coin.getName())
                .build();
    }
}
