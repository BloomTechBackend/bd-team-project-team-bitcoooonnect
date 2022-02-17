
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
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

}
