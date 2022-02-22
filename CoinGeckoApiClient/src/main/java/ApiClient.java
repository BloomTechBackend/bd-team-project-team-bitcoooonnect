import java.util.Map;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import okhttp3.*;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


public class ApiClient {
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    public static final OkHttpClient client = new OkHttpClient();

    public static void updateCoinPrice() throws Exception {

        JSONObject coinsObject = new JSONObject();
        JSONObject coinsListObject = new JSONObject();

        Request request1 = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/cryptocurrency/" +
                        "listings/latest?start=1&limit=5000&convert=USD")
                .header("X-CMC_PRO_API_KEY", "f8137c54-5648-4e3e-92eb-9e64a4e36b4e")
                .build();

        final Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(Map.class, String.class,
                Object.class);

        final JsonAdapter<Map<String, Object>> jsonAdapter =
                moshi.adapter(type);

        Map<String, Object> gist1;
        List<Map<String, Object>> gist2;
        try (Response response = client.newCall(request1).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            gist1 = jsonAdapter.fromJson(response.body().source());
            gist2 = (List) gist1.get("data");

            System.out.println("size :" + gist2.size());


            for (Map<String, Object> coin : gist2) {

                Map<String, Map<String, Object>> quote = (Map)coin.get("quote");

                coinsListObject.put(coin.get("name"), quote.get("USD").get(
                        "price"));
            }
        }
        coinsObject.put("coins", coinsListObject);

        RequestBody body = RequestBody.create(coinsObject.toJSONString(), JSON);
        Request request = new Request.Builder()
                .url("https://t3d210uhn7.execute-api.us-east-2.amazonaws.com/test/coins")
                .put(body)
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            System.out.println(response.body().string());
        }
    }
}
