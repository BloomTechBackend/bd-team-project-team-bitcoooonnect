package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class GetUserRequest {
    private String emailId;

    public GetUserRequest(String emailId) {
        this.emailId = emailId;
    }

    public GetUserRequest() {

    }

    public GetUserRequest(Builder builder) {
        this.emailId = builder.emailId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserRequest that = (GetUserRequest) o;
        return emailId.equals(that.emailId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailId);
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "authToken='" + emailId + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String emailId;

        private Builder() {

        }

        public Builder withEmailIdToUse(String emailIdToUse) {
            this.emailId = emailIdToUse;
            return this;
        }

        public GetUserRequest build() {
            return new GetUserRequest(this);
        }
    }
}
