package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class CreateUserRequest {
    private String emailId;

    public CreateUserRequest(String emailId) {
        this.emailId = emailId;
    }

    public CreateUserRequest() {

    }

    public CreateUserRequest(Builder builder) {
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
        CreateUserRequest that = (CreateUserRequest) o;
        return getEmailId().equals(that.getEmailId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmailId());
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "id='" + emailId + '\'' +
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

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}



