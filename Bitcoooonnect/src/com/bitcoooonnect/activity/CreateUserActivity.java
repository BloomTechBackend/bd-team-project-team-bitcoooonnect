package com.bitcoooonnect.activity;


import com.bitcoooonnect.converters.ModelConverter;
import com.bitcoooonnect.dynamodb.UserDao;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.exceptions.InvalidAttributeException;
import com.bitcoooonnect.models.UserModel;
import com.bitcoooonnect.models.requests.CreateUserRequest;
import com.bitcoooonnect.models.results.CreateUserResult;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

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

        String requestedEmail = createUserRequest.getEmail();
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
        if(!requestedEmail.matches(emailRegex)) {
            throw new InvalidAttributeException("Invalid email, please enter a valid email");
        }

        String requestedPassword = createUserRequest.getPassword();

        User user = new User();
        user.setEmail(requestedEmail);
        user.setPassword(requestedPassword);
        user.setCoins(null);

        userDao.saveUser(user);
        UserModel userModel = new ModelConverter().toUserModel(user);
        return CreateUserResult.builder()
                .withUser(userModel)
                .build();
    }
}
