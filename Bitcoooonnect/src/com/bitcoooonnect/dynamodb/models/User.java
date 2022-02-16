package com.bitcoooonnect.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.HashMap;
import java.util.Map;

@DynamoDBTable(tableName = "users")
public class User {
    private String id;
    private String name;
    private Map<String, Double> coins = new HashMap<>();

    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "coins")
    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Double> coins) {
        this.coins = coins;
    }
}
