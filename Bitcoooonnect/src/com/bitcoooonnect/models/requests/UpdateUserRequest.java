package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class UpdateUserRequest {
    private String authToken;
    private String coinId;
    private Double amount;

    public UpdateUserRequest() {

    }

    public UpdateUserRequest(String authToken, String coinId, Double amount) {
        this.authToken = authToken;
        this.coinId = coinId;
        this.amount = amount;
    }

    public UpdateUserRequest(Builder builder) {
        this.authToken = builder.authToken;
        this.coinId = builder.coinId;
        this.amount = builder.amount;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserRequest that = (UpdateUserRequest) o;
        return getAuthToken().equals(that.getAuthToken()) && Objects.equals(getCoinId(), that.getCoinId()) && Objects.equals(getAmount(), that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthToken(), getCoinId(), getAmount());
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "authToken='" + authToken + '\'' +
                ", coinId='" + coinId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String authToken;
        private String coinId;
        private Double amount;

        private Builder() {

        }

        public Builder withAutthToken(String authTokenToUse) {
            this.authToken = authTokenToUse;
            return this;
        }

        public Builder withCoinId(String coinIdToUse) {
            this.coinId = coinIdToUse;
            return this;
        }

        public Builder withAmount(Double amountToUse) {
            this.amount = amountToUse;
            return this;
        }

        public UpdateUserRequest build() {
            return new UpdateUserRequest(this);
        }
    }
}
