package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class CreateUserRequest {
    private String authToken;

    public CreateUserRequest(String email, String password) {
        this.authToken = email;
    }

    public CreateUserRequest() {

    }

    public CreateUserRequest(Builder builder) {
        this.authToken = builder.authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserRequest that = (CreateUserRequest) o;
        return getAuthToken().equals(that.getAuthToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthToken());
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "id='" + authToken + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String authToken;

        private Builder() {

        }

        public Builder withAuthTokenToUse(String authToken) {
            this.authToken = authToken;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}



