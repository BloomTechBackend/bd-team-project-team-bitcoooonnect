package com.bitcoooonnect.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserModel {
    private String emailId;
    private Map<String, Double> coins = new HashMap<>();

    public UserModel() {

    }

    public UserModel(Builder builder) {
        this.emailId = builder.emailId;
        this.coins = builder.coins;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
        UserModel userModel = (UserModel) o;
        return getEmailId().equals(userModel.getEmailId()) && Objects.equals(getCoins(), userModel.getCoins());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailId(), getCoins());
    }


    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String emailId;
        private Map<String, Double> coins = new HashMap<>();

        public Builder withEmailId(String emailIdToUse) {
            this.emailId = emailIdToUse;
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
