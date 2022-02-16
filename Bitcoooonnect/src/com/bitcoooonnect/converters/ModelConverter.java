package com.bitcoooonnect.converters;

import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.UserModel;

public class ModelConverter {

    public UserModel toUserModel(User user) {
        if(user.getCoins() == null) {
            return UserModel.builder()
                    .withId(user.getId())
                    .withName(user.getName())
                    .withCoins(null)
                    .build();
        }
        return UserModel.builder()
                .withId(user.getId())
                .withName(user.getName())
                .withCoins(user.getCoins())
                .build();
    }
}
