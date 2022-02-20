package com.bitcoooonnect.models.results;

import com.bitcoooonnect.models.CoinModel;

import java.util.List;

public class GetCoinResult {
    private List<CoinModel> coins;

    public GetCoinResult(GetCoinResult.Builder builder) {
        this.coins = builder.coins;
    }

    public List<CoinModel> getCoins() {
        return coins;
    }

    public void setCoins(List<CoinModel> coins) {
        this.coins = coins;
    }

    public static GetCoinResult.Builder builder() {
        return new GetCoinResult.Builder();
    }

    public static final class Builder {
        private List<CoinModel> coins;


        public GetCoinResult.Builder withCoins(List<CoinModel> coins) {
            this.coins = coins;
            return this;
        }

        public GetCoinResult build() {
            return new GetCoinResult(this);
        }
    }
}
