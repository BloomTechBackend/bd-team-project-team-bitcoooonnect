package com.bitcoooonnect.models.results;

import com.bitcoooonnect.models.CoinModel;
import com.bitcoooonnect.models.UserModel;

import java.util.List;
import java.util.Map;

public class GetUserResult {
    private UserModel user;
    private Map<String, Map<String, Double>> coins;

    public GetUserResult(Builder builder) {
        this.user = builder.user;
        this.coins = builder.coins;
    }

    public UserModel getUser() {
        return user;
    }

    public Map<String, Map<String, Double>> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Map<String, Double>> coins) {
        this.coins = coins;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserModel user;
        private Map<String, Map<String, Double>> coins;


        public Builder withCoins(Map<String, Map<String, Double>> coins) {
            this.coins = coins;
            return this;
        }

        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public GetUserResult build() {
            return new GetUserResult(this);
        }
    }
}
