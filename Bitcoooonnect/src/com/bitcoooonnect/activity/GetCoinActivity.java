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

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

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

        String requestedId = getCoinRequest.getId();

        Coin coin = coinDao.getCoin(requestedId);
        CoinModel coinModel = new ModelConverter().toCoinModel(coin);

        return GetCoinResult.builder()
                .withCoin(coinModel)
                .build();
    }
}
