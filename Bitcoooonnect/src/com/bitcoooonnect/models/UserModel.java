package com.bitcoooonnect.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserModel {
    private String id;
    private String name;
    private Map<String, Double> coins = new HashMap<>();

    public UserModel() {

    }

    public UserModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.coins = builder.coins;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return getId().equals(userModel.getId()) && Objects.equals(getName(), userModel.getName()) && Objects.equals(getCoins(), userModel.getCoins());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCoins());
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", coins=" + coins +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String id;
        private String name;
        private Map<String, Double> coins = new HashMap<>();

        public Builder withId(String idToUse) {
            this.id = idToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = name;
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
