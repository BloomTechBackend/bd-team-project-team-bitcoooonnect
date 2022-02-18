package com.bitcoooonnect.activity;


import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.UserModel;
import com.bitcoooonnect.models.requests.CreateUserRequest;
import com.bitcoooonnect.models.requests.GetUserRequest;
import com.bitcoooonnect.models.results.CreateUserResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.bitcoooonnect.models.results.GetUserResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.mustache.Model;

import javax.inject.Inject;

public class GetUserActivity implements RequestHandler<GetUserRequest, GetUserResult> {
    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;

    @Inject
    public GetUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public GetUserResult handleRequest(final GetUserRequest getUserRequest, Context context) {
//        log.info("Received CreateUserRequest {}", CreateUserRequest);
        String userEmail = getUserRequest.getEmail();
        User user = userDao.getUser(userEmail);

        UserModel userModel =  new ModelConverter().toUserModel(user);

        return GetUserResult.builder()
                .withUser(userModel)
                .build();
    }
}