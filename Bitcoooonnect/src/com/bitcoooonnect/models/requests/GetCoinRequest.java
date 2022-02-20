package com.bitcoooonnect.models.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetCoinRequest {
    private List<String> ids = new ArrayList<>();

    public GetCoinRequest(List<String> ids) {
        this.ids = ids;
    }

    public GetCoinRequest() {

    }

    public GetCoinRequest(Builder builder) {
        this.ids = builder.ids;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCoinRequest that = (GetCoinRequest) o;
        return ids.equals(that.ids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids);
    }

    @Override
    public String toString() {
        return "GetCoinRequest{" +
                ", ids='" + ids + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private List<String> ids = new ArrayList<>();

        private Builder() {

        }

        public Builder withIdsToUse(List<String> ids) {
            this.ids = ids;
            return this;
        }

        public GetCoinRequest build() {
            return new GetCoinRequest(this);
        }
    }
}
