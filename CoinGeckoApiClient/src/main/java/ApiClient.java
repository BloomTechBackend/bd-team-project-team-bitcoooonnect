import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ApiClient {
    public static void main(String[] args) throws Exception {
        run();
    }
    public static void run() throws Exception {
        final OkHttpClient client = new OkHttpClient();
        final Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Map.class);
        final JsonAdapter<List<Map<String, Object>>> jsonAdapter =
                moshi.adapter(type);
        Request request = new Request.Builder()
                .url("https://api.coingecko" +
                        ".com/api/v3/coins/markets?vs_currency=usd&per_page" +
                        "=250")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            List<Map<String, Object>> gist =
                    jsonAdapter.fromJson(response.body().source());

            for (Map<String, Object> coin : gist) {
                System.out.print(coin.get("id") + " ");
                System.out.print(coin.get("symbol") + " ");
                System.out.println(coin.get("current_price") + " ");
            }
        }
    }

    public static void initCoinList() throws Exception {
        final OkHttpClient client = new OkHttpClient();
        final Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Map.class);
        final JsonAdapter<List<Map<String, Object>>> jsonAdapter =
                moshi.adapter(type);
        Request request = new Request.Builder()
                .url("https://api.coingecko" +
                        ".com/api/v3/coins/markets?vs_currency=usd&per_page" +
                        "=250")
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            List<Map<String, Object>> gist =
                    jsonAdapter.fromJson(response.body().source());

            String filename = "src/main/cloudformation/coin.json";
            JSONObject coinsObject = new JSONObject();

            JSONArray coinsList = new JSONArray();

            coinsObject.put("coins", coinsList);

            for (Map<String, Object> coin : gist) {
                JSONObject sampleObject3 = new JSONObject();
                sampleObject3.put("id", coin.get("symbol"));
                sampleObject3.put("name", coin.get("id"));
                sampleObject3.put("price", coin.get("current_price"));

                coinsList.add(sampleObject3);
            }
            Files.write(Paths.get(filename), coinsObject.toJSONString().getBytes());
        }
    }
}
