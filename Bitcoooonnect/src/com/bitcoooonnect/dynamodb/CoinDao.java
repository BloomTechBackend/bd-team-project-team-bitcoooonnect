package com.bitcoooonnect.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.KeyPair;
import com.bitcoooonnect.dynamodb.models.Coin;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinDao {
    private final DynamoDBMapper dynamoDBMapper;

    @Inject
    public CoinDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Map<String, List<Object>> getCoin(List<String> ids){

        List<KeyPair> keyPairList = new ArrayList<>();
        for(String id : ids) {
            KeyPair keyPair = new KeyPair();
            keyPair.withHashKey(id);
            keyPairList.add(keyPair);
        }

        Map<Class<?>, List<KeyPair>> keyPairForTable = new HashMap<>();
        keyPairForTable.put(Coin.class, keyPairList);

        Map<String, List<Object>> coins =
                this.dynamoDBMapper.batchLoad(keyPairForTable);

        for (Map.Entry<String, List<Object>> entry : coins.entrySet()) {
            System.out.println("entry key: " + entry.getKey());
            System.out.println("entry value: " + entry.getValue());
        }

        return coins;
    }

    public List<Coin> saveCoins(List<Coin> coins){
        this.dynamoDBMapper.batchSave(coins);
        return coins;
    }
}
