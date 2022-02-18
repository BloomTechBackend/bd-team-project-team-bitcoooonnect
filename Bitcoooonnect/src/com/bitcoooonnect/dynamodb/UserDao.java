package com.bitcoooonnect.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bitcoooonnect.dynamodb.models.User;

import javax.inject.Inject;

public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public User getUser(String email){
        User user = this.dynamoDBMapper.load(User.class, email);
        return user;
    }

    public User saveUser(User user){
        dynamoDBMapper.save(user);
        return user;
    }
}
