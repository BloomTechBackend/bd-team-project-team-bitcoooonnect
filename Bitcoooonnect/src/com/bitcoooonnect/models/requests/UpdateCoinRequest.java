package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class UpdateCoinRequest {
    private String id;
    private Double price;
    private String name;
    
    public UpdateCoinRequest() {
        
    }
    
    public UpdateCoinRequest(String id, Double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }
    
    public UpdateCoinRequest(Builder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCoinRequest that = (UpdateCoinRequest) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "UpdateCoinRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static UpdateCoinRequest.Builder builder() {
        return new UpdateCoinRequest.Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private Double price;

        private Builder() {

        }

        public UpdateCoinRequest.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public UpdateCoinRequest.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public UpdateCoinRequest.Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public UpdateCoinRequest build() {
            return new UpdateCoinRequest(this);
        }
    }
}
