package com.bitcoooonnect.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bitcoooonnect.dynamodb.models.User;

public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;

    public UserDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

//    public User getUser(){}
//
//    public User saveUser(){}
}
