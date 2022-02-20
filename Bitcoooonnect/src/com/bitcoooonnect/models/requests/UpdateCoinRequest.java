package com.bitcoooonnect.models.requests;

import java.util.*;

public class UpdateCoinRequest {
    private Map<String, Double> coins = new HashMap<>();

    public UpdateCoinRequest() {
        
    }
    
    public UpdateCoinRequest(Map<String, Double> coins) {
        this.coins = coins;
    }
    
    public UpdateCoinRequest(Builder builder) {
        this.coins = builder.coins;
    }

    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Double> coins) {
        this.coins = coins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCoinRequest that = (UpdateCoinRequest) o;
        return getCoins().equals(that.getCoins());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoins());
    }

    @Override
    public String toString() {
        return "UpdateCoinRequest{" +
                "coins='" + coins + '\'' +
                '}';
    }

    public static UpdateCoinRequest.Builder builder() {
        return new UpdateCoinRequest.Builder();
    }

    public static final class Builder {
        private Map<String, Double> coins = new HashMap<>();

        private Builder() {

        }

        public UpdateCoinRequest.Builder withCoins(Map<String, Double> coins) {
            this.coins = coins;
            return this;
        }

        public UpdateCoinRequest.Builder withId(Map<String, Double> coins) {
            this.coins = coins;
            return this;
        }

        public UpdateCoinRequest build() {
            return new UpdateCoinRequest(this);
        }
    }
}
