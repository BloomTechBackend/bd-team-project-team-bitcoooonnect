package com.bitcoooonnect.models.requests;

import com.amazonaws.services.dynamodbv2.model.Get;

import java.util.Objects;

public class GetUserRequest {
    private String email;
    private String password;

    public GetUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public GetUserRequest() {

    }

    public GetUserRequest(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserRequest that = (GetUserRequest) o;
        return email.equals(that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    @Override
    public String toString() {
        return "GetUserRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String email;
        private String password;

        private Builder() {

        }

        public Builder withEmailToUse(String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public Builder withPassWordToUse(String passWordToUse) {
            this.password = passWordToUse;
            return this;
        }


        public GetUserRequest build() {
            return new GetUserRequest(this);
        }
    }
}
