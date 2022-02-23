package com.bitcoooonnect.models;

import java.util.HashMap;
import java.util.Map;

public class UserModel {
    private String authToken;
    private Map<String, Double> coins = new HashMap<>();

    public UserModel() {

    }

    public UserModel(Builder builder) {
        this.authToken = builder.authToken;
        this.coins = builder.coins;
    }


    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Double> coins) {
        this.coins = coins;
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String authToken;
        private Map<String, Double> coins = new HashMap<>();

        public Builder withAuthToken(String authTokenToUse) {
            this.authToken = authTokenToUse;
            return this;
        }

        public Builder withCoins(Map<String, Double> coinsToUse) {
            this.coins = coinsToUse;
            return this;
        }

        public UserModel build() {
            return new UserModel(this);
        }
    }
}
