package com.bitcoooonnect.converters;

import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.CoinModel;
import com.bitcoooonnect.models.UserModel;

public class ModelConverter {

    public UserModel toUserModel(User user) {
        if(user.getCoins() == null) {
            return UserModel.builder()
                    .withAuthToken(user.getAuthToken());
                    .withCoins(null)
                    .build();
        }
        return UserModel.builder()
                .withAuthToken(user.getAuthToken());
                .withCoins(user.getCoins())
                .build();
    }

    public CoinModel toCoinModel(Coin coin) {
        return CoinModel.builder()
                .withId(coin.getId())
                .withName(coin.getName())
                .withPrice(coin.getPrice())
                .build();
    }
}
