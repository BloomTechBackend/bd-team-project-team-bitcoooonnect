package com.bitcoooonnect.models.requests;

import java.util.Objects;

public class CreateUserRequest {
    private String id;
    private String name;

    public CreateUserRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CreateUserRequest() {

    }

    public CreateUserRequest(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return getId().equals(that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;

        private Builder() {

        }

        public Builder withId(String IdToUse) {
            this.id = IdToUse;
            return this;
        }

        public Builder withName(String nameToUse) {
            this.name = nameToUse;
            return this;
        }

        public CreateUserRequest build() {
            return new CreateUserRequest(this);
        }
    }
}



