package com.bitcoooonnect.models.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetCoinRequest {
    private String id;
    private List<String> ids = new ArrayList<>();
    //  Set<String> ids = new HashSet<String>();


    public GetCoinRequest(String id) {
        this.id = id;
    }

    public GetCoinRequest(List<String> ids) {
        this.ids = ids;
    }

    public GetCoinRequest() {

    }

    public GetCoinRequest(Builder builder) {
        this.id = builder.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetCoinRequest that = (GetCoinRequest) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GetCoinRequest{" +
                ", id='" + id + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private List<String> ids = new ArrayList<>();

        private Builder() {

        }

        public Builder withIdToUse(String id) {
            this.id = id;
            return this;
        }

        public GetCoinRequest build() {
            return new GetCoinRequest(this);
        }
    }
}
