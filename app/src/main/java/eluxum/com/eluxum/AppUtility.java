package eluxum.com.eluxum;

import retrofit2.Retrofit;

public class AppUtility {
    public static final String BASE = "http://eluxum-shop.herokuapp.com/";
    public static AppService getAppService() {
        return Client.Get(BASE).create(AppService.class);
    }
}
