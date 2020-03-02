package eluxum.com.eluxum;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AppService {
    @FormUrlEncoded
    @POST("/api/v1/auth/login")
    Call<ResponseBody> appLogin(@Field("email") String email, @Field("password") String password);
}
