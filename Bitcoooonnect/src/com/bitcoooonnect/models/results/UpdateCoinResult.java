package com.bitcoooonnect.models.results;

import com.bitcoooonnect.dynamodb.models.Coin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateCoinResult {
    private Map<String, Double> coins = new HashMap<>();

    public UpdateCoinResult(UpdateCoinResult.Builder builder) {
        this.coins = builder.coins;
    }

    public Map<String, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<String, Double> coins) {
        this.coins = coins;
    }

    public static UpdateCoinResult.Builder builder(){
        return new UpdateCoinResult.Builder();
    }

    public static final class Builder {
        private Map<String, Double> coins = new HashMap<>();

        private Builder() {

        }

        public UpdateCoinResult.Builder withCoins(List<Coin> allCoins) {
            for (Coin coin : allCoins) {
                coins.put(coin.getId(), coin.getPrice());
            }
            return this;
        }

        public UpdateCoinResult build() {
            return new UpdateCoinResult(this);
        }
    }
}
