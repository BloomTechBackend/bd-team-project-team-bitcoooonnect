package com.bitcoooonnect.converters;

import com.bitcoooonnect.dynamodb.models.Coin;
import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.CoinModel;
import com.bitcoooonnect.models.UserModel;

public class ModelConverter {

    public UserModel toUserModel(User user) {
        if(user.getCoins() == null) {
            return UserModel.builder()
                    .withEmail(user.getEmail())
                    .withPassword(user.getPassword())
                    .withCoins(null)
                    .build();
        }
        return UserModel.builder()
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
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
