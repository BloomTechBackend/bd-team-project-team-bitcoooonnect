package com.bitcoooonnect.models;

import java.util.HashMap;
import java.util.Map;

public class CoinModel {
    private String id;
    private String name;
    private Double price;

    public CoinModel() {

    }
    public CoinModel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static CoinModel.Builder builder() { return new CoinModel.Builder(); }

    public static final class Builder {
        private String id;
        private String name;
        private Double price;

        public CoinModel.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public CoinModel.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public CoinModel.Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public CoinModel build() {
            return new CoinModel(this);
        }
    }
}
