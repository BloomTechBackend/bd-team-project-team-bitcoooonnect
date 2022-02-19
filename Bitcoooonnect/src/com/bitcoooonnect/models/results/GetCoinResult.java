package com.bitcoooonnect.models.results;

import com.bitcoooonnect.models.CoinModel;

public class GetCoinResult {
    private CoinModel coin;

    public GetCoinResult(GetCoinResult.Builder builder) {
        this.coin = builder.coin;
    }

    public CoinModel getCoin() {
        return coin;
    }

    public void setCoin(CoinModel coin) {
        this.coin = coin;
    }

    public static GetCoinResult.Builder builder() {
        return new GetCoinResult.Builder();
    }

    public static final class Builder {
        private CoinModel coin;


        public GetCoinResult.Builder withCoin(CoinModel coin) {
            this.coin = coin;
            return this;
        }

        public GetCoinResult build() {
            return new GetCoinResult(this);
        }
    }
}
