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

        List<CoinModel> coinModels = new ArrayList<>();
        List<Coin> allCoins = new ArrayList<>();

        for(Map.Entry<String, Double> coinPair :
                updateCoinRequest.getCoins().entrySet() ) {
            Double price = coinPair.getValue();
            String id = coinPair.getKey();
            Coin coin = new Coin();
            coin.setId(id);
            coin.setPrice(price);
            coinModels.add(new ModelConverter().toCoinModel(coin));
            allCoins.add(coin);
        }

        coinDao.saveCoins(allCoins);

        return UpdateCoinResult.builder()
                .withCoins(allCoins)
                .build();
    }
}
