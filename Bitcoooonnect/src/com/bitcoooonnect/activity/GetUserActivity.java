package com.bitcoooonnect.activity;


import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.exceptions.InvalidAttributeException;
import com.bitcoooonnect.models.UserModel;
import com.bitcoooonnect.models.requests.GetUserRequest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.bitcoooonnect.models.results.GetUserResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        String userEmail = getUserRequest.getAuthToken();

        User user = userDao.getUser(userEmail);

        if(user == null) {
            throw new InvalidAttributeException("Invalid email address, no user exists with this email!");
        }

        if(!user.getPassword().equals(getUserRequest.getPassword())) {
            throw new InvalidAttributeException("Wrong password!");
        }

        UserModel userModel =  new ModelConverter().toUserModel(user);

        return GetUserResult.builder()
                .withUser(userModel)
                .build();
    }
}