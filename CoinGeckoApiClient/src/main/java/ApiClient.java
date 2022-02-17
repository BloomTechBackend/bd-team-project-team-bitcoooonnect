import java.nio.file.Files;
import java.nio.file.Paths;
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
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class ApiClient {
    public static void main(String[] args) throws Exception {
//        runAllInitCoinList();
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

    public static void runAllInitCoinList() throws Exception {
        for(int i = 1; i <=10; i++) {
            initCoinList(Integer.toString(i));
        }
    }

    public static void initCoinList(String num) throws Exception {
        String filename = "src/main/cloudformation/coin" + num + ".json";
        File newFile = new File(filename);
        newFile.createNewFile();

        final OkHttpClient client = new OkHttpClient();
        final Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Map.class);
        final JsonAdapter<List<Map<String, Object>>> jsonAdapter =
                moshi.adapter(type);
        Request request = new Request.Builder()
                .url("https://api.coingecko" +
                        ".com/api/v3/coins/markets?vs_currency=usd&per_page" +
                        "=25&page=" + num)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            List<Map<String, Object>> gist =
                    jsonAdapter.fromJson(response.body().source());

            JSONObject coinsObject = new JSONObject();

            JSONArray coinsList = new JSONArray();

            coinsObject.put("coins", coinsList);

            for (Map<String, Object> coin : gist) {
                JSONObject idDetails= new JSONObject();
                JSONObject nameDetails = new JSONObject();
                JSONObject priceDetails = new JSONObject();
                idDetails.put("S", coin.get("symbol"));
                nameDetails.put("S", coin.get("id"));
                priceDetails.put("N", coin.get("current_price").toString());

                JSONObject allDetailsObject = new JSONObject();;
                allDetailsObject.put("id", idDetails);
                allDetailsObject.put("name", nameDetails);
                allDetailsObject.put("price", priceDetails);

                JSONObject itemObject = new JSONObject();
                itemObject.put("Item", allDetailsObject );

                JSONObject putRequestObject = new JSONObject();
                putRequestObject.put("PutRequest", itemObject);

                coinsList.add(putRequestObject);
            }
            Files.write(Paths.get(filename), coinsObject.toJSONString().getBytes());
        }
    }
}
