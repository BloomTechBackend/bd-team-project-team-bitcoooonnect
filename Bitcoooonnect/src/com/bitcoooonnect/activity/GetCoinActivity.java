package com.bitcoooonnect.activity;


import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.CoinDao;
import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.models.CoinModel;
import com.bitcoooonnect.models.requests.GetCoinRequest;
import com.bitcoooonnect.models.results.GetCoinResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetCoinActivity implements RequestHandler<GetCoinRequest,
        GetCoinResult> {
    private final Logger log = LogManager.getLogger();
    private final CoinDao coinDao;

    /**
     * Instantiates a new GetCoinActivity object.
     *
     * @param coinDao CoinDao to access the coin table.
     */
    @Inject
    public GetCoinActivity(CoinDao coinDao) {
        this.coinDao = coinDao;
    }

    /**
     * This method handles the incoming request by retrieving the coin from the
     * database.
     * <p>
     * It then returns the coin.
     * <p>
     * If the coin does not exist, this should throw a
     * CoinNotFoundException.
     *
     * @param getCoinRequest request object containing the coin ID
     * @return getCoinResult result object containing the Coin
     */
    @Override
    public GetCoinResult handleRequest(final GetCoinRequest getCoinRequest,
                                       Context context) {
        log.info("Received GetUserRequest {}", getCoinRequest);

        List<String> requestedIds = getCoinRequest.getIds();

        Map<String, List<Object>> coins = coinDao.getCoin(requestedIds);

        List<CoinModel> coinModels = new ArrayList<>();

        for(Object coin : coins.get("coins") ) {
            coinModels.add(new ModelConverter().toCoinModel((Coin) coin));
        }

        return GetCoinResult.builder()
                .withCoins(coinModels)
                .build();
    }
}
