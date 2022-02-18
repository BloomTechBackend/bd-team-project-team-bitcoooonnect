package com.bitcoooonnect.models.results;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserResult {
    private Map<String, Double> coins = new HashMap<>();

    public UpdateUserResult(Builder builder) {
        this.coins = builder.coins;
    }

    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Double> coins) {
        this.coins = coins;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private Map<String, Double> coins = new HashMap<>();

        public Builder withCoinList(Map<String, Double> coinListToUse) {
            this.coins = coinListToUse;
            return this;
        }

        public UpdateUserResult build() {
            return new UpdateUserResult(this);
        }

    }
}
