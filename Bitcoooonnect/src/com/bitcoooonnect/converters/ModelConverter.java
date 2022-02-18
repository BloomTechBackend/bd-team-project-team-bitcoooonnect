package com.bitcoooonnect.converters;

import com.bitcoooonnect.dynamodb.models.User;
import com.bitcoooonnect.models.UserModel;

public class ModelConverter {

    public UserModel toUserModel(User user) {
        if(user.getCoins() == null) {
            return UserModel.builder()
                    .withId(user.getId())
                    .withEmail(user.getEmail())
                    .withPassword(user.getPassword())
                    .withCoins(null)
                    .build();
        }
        return UserModel.builder()
                .withId(user.getId())
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withCoins(user.getCoins())
                .build();
    }
}
