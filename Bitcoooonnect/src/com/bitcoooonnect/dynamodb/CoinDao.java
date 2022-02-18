package com.bitcoooonnect.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.bitcoooonnect.dynamodb.models.Coin;

import javax.inject.Inject;

public class CoinDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public CoinDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Coin getCoin(String id){
        Coin coin = this.dynamoDBMapper.load(Coin.class, id);
        return coin;
    }

    public Coin saveCoin(Coin coin){
        this.dynamoDBMapper.save(coin);
        return coin;
    }
}
