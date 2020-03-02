package eluxum.com.eluxum;

import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static final String BASE = "http://eluxum-shop.herokuapp.com/";
    private static Retrofit retrofit = null;

    public static Retrofit Get(String address) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(address).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}