package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class GetUserRequest {
    private String authToken;

    public GetUserRequest(String authToken) {
        this.authToken = authToken;
    }

    public GetUserRequest() {

    }

    public GetUserRequest(Builder builder) {
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
        GetUserRequest that = (GetUserRequest) o;
        return authToken.equals(that.authToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authToken);
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "authToken='" + authToken + '\'' +
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

        public GetUserRequest build() {
            return new GetUserRequest(this);
        }
    }
}
