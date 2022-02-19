package com.bitcoooonnect.models.results;

import java.util.HashMap;
import java.util.Map;

public class UpdateCoinResult {
    private String id;
    private Double price;
    private String name;

    public UpdateCoinResult(UpdateCoinResult.Builder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static UpdateCoinResult.Builder builder(){
        return new UpdateCoinResult.Builder();
    }

    public static final class Builder{
        private Double price;
        private String id;
        private String name;

        public UpdateCoinResult.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public UpdateCoinResult.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public UpdateCoinResult.Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public UpdateCoinResult build() {
            return new UpdateCoinResult(this);
        }

    }
}
