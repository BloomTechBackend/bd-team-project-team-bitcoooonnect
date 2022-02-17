package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class CreateUserRequest {
    private String email;
    private String name;

    public CreateUserRequest(String id, String name) {
        this.email = id;
        this.name = name;
    }

    public CreateUserRequest() {

    }

    public CreateUserRequest(Builder builder) {
        this.email = builder.email;
        this.name = builder.password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        CreateUserRequest that = (CreateUserRequest) o;
        return getEmail().equals(that.getEmail()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getName());
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "id='" + email + '\'' +
                ", name='" + name + '\'' +
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

        public Builder withPassword(String passwordToUse) {
            this.password = passwordToUse;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}



