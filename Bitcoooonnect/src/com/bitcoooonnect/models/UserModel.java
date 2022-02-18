package com.bitcoooonnect.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserModel {
    private String email;
    private String password;
    private Map<String, Double> coins = new HashMap<>();

    public UserModel() {

    }

    public UserModel(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
        this.coins = builder.coins;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return getEmail().equals(userModel.getEmail()) && Objects.equals(getPassword(), userModel.getPassword()) && Objects.equals(getCoins(), userModel.getCoins());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword(), getCoins());
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + email + '\'' +
                ", name='" + password + '\'' +
                ", coins=" + coins +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String email;
        private String password;
        private Map<String, Double> coins = new HashMap<>();

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public Builder withPassword(String passwordToUse) {
            this.password = passwordToUse;
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
