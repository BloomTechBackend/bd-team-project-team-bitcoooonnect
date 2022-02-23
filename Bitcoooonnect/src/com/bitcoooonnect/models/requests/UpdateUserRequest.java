package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class UpdateUserRequest {
    private String emailId;
    private String coinId;
    private Double amount;

    public UpdateUserRequest() {

    }

    public UpdateUserRequest(String emailId, String coinId, Double amount) {
        this.emailId = emailId;
        this.coinId = coinId;
        this.amount = amount;
    }

    public UpdateUserRequest(Builder builder) {
        this.emailId = builder.emailId;
        this.coinId = builder.coinId;
        this.amount = builder.amount;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
        return getEmailId().equals(that.getEmailId()) && Objects.equals(getCoinId(), that.getCoinId()) && Objects.equals(getAmount(), that.getAmount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailId(), getCoinId(), getAmount());
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "authToken='" + emailId + '\'' +
                ", coinId='" + coinId + '\'' +
                ", amount=" + amount +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String emailId;
        private String coinId;
        private Double amount;

        private Builder() {

        }

        public Builder withEmailId(String emailIdToUse) {
            this.emailId = emailIdToUse;
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
