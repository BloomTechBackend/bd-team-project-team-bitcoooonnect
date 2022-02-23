package com.bitcoooonnect.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.HashMap;
import java.util.Map;

@DynamoDBTable(tableName = "users")
public class User {
    private String authToken;
    private Map<String, Double> coins = new HashMap<>();

    @DynamoDBHashKey(attributeName = "authToken")
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @DynamoDBAttribute(attributeName = "coins")
    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Double> coins) {
        this.coins = coins;
    }
}
