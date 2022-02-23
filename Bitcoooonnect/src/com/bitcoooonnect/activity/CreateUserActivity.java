package com.bitcoooonnect.activity;


import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.UserModel;
import com.bitcoooonnect.models.requests.CreateUserRequest;
import com.bitcoooonnect.models.results.CreateUserResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.UUID;

public class CreateUserActivity implements RequestHandler<CreateUserRequest, CreateUserResult> {
    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;

    @Inject
    public CreateUserActivity(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CreateUserResult handleRequest(final CreateUserRequest createUserRequest, Context context) {
//        log.info("Received CreateUserRequest {}", CreateUserRequest);


        User user = new User();
        user.setEmailId(createUserRequest.getEmailId());
        user.setCoins(null);

        userDao.saveUser(user);

        UserModel userModel = new ModelConverter().toUserModel(user);
        return CreateUserResult.builder()
                .withUser(userModel)
                .build();
    }
}
