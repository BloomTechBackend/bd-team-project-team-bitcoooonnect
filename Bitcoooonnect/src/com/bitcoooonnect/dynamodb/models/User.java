package com.bitcoooonnect.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "user")
public class User {
    private String authToken;
    private String name;
    private List<String> coins;

    @DynamoDBHashKey(attributeName = "authToken")
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBRangeKey(attributeName = "coins")
    public List<String> getCoins() {
        return coins;
    }

    public void setCoins(List<String> coins) {
        this.coins = coins;
    }
}
