package com.bitcoooonnect.models.results;

import com.bitcoooonnect.models.UserModel;

public class GetUserResult {
    private UserModel user;

    public GetUserResult(Builder builder) {
        this.user = builder.user;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private UserModel user;


        public Builder withUser(UserModel user) {
            this.user = user;
            return this;
        }

        public GetUserResult build() {
            return new GetUserResult(this);
        }
    }
}
