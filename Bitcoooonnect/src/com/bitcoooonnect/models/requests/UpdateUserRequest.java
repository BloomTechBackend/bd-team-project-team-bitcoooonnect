package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class UpdateUserRequest {
    private String email;
    private String coinId;
    private Double amount;

    public UpdateUserRequest() {

    }

    public UpdateUserRequest(String email, String coinId, Double amount) {
        this.email = email;
        this.coinId = coinId;
        this.amount = amount;
    }

    public UpdateUserRequest(Builder builder) {
        this.email = builder.email;
        this.coinId = builder.coinId;
        this.amount = builder.amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return getEmail().equals(that.getEmail()) && Objects.equals(getCoinId(), that.getCoinId()) && Objects.equals(getAmount(), that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getCoinId(), getAmount());
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "email='" + email + '\'' +
                ", coinId='" + coinId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String email;
        private String coinId;
        private Double amount;

        private Builder() {

        }

        public Builder withEmail(String emailToUse) {
            this.email = emailToUse;
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
