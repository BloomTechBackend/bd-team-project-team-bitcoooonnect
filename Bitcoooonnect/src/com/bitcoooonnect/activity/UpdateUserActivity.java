package com.bitcoooonnect.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.requests.UpdateUserRequest;
import com.bitcoooonnect.models.results.UpdateUserResult;

import javax.inject.Inject;
import java.util.Map;

public class UpdateUserActivity implements RequestHandler<UpdateUserRequest, UpdateUserResult> {
    private final UserDao userDao;

    @Inject
    public UpdateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UpdateUserResult handleRequest(final UpdateUserRequest updateUserRequest, Context context) {
        User user = userDao.getUser(updateUserRequest.getAuthToken());
        Map<String, Double> coins = user.getCoins();
        coins.put(updateUserRequest.getCoinId(), updateUserRequest.getAmount());
        user.setCoins(coins);

        userDao.saveUser(user);

        return UpdateUserResult.builder()
                .withCoinList(coins)
                .build();
    }
}
