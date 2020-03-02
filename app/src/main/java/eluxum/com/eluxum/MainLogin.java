package eluxum.com.eluxum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.text.AutoText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.text.SimpleDateFormat;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Body;

public class MainLogin extends AppCompatActivity {
    private AppService appService;
    Button bLogin;
    EditText eUsername;
    TextInputEditText tPassword;
    TextView tForgotLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = (Button)findViewById(R.id.btn_signin);
        eUsername = (EditText)findViewById(R.id.et_username);
        tPassword = (TextInputEditText)findViewById(R.id.et_tiet);
        tForgotLogin = (TextView)findViewById(R.id.tv_forgotloginpass);
        appService = AppUtility.getAppService();

        initComponent();
    }

    public void eventLogin() {
        Intent i = new Intent(MainLogin.this, Home.class);
        startActivity(i);
        MainLogin.this.finish();
    }

    public void initComponent() {
        tForgotLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainLogin.this, MainForgot.class);
                startActivity(i);
                MainLogin.this.finish();
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUser = eUsername.getText().toString();
                String sPass = tPassword.getText().toString();

                if (sUser.equals("") || sPass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please fill username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                appService.appLogin(sUser, sPass).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            JSONObject res = new JSONObject(response.body().string());
                            if (response.isSuccessful()) {
                                if (!res.isNull("id"))
                                    DataAccount.id = res.getInt("id");
                                if (!res.isNull("email"))
                                    DataAccount.email = res.getString("email");
                                if (!res.isNull("name"))
                                    DataAccount.name = res.getString("name");
                                if (!res.isNull("username"))
                                    DataAccount.username = res.getString("username");
                                if (!res.isNull("photo"))
                                    DataAccount.u_photo = res.getString("photo");
                                if (!res.isNull("u_access"))
                                    DataAccount.u_access = res.getString("u_access");
                                if (!res.isNull("u_phone_number"))
                                    DataAccount.u_phone_number = res.getString("u_phone_number");
                                if (!res.isNull("u_address"))
                                    DataAccount.u_address = res.getString("u_address");
                                if (!res.isNull("u_bio"))
                                    DataAccount.u_bio = res.getString("u_bio");
                                if (!res.isNull("followed_user_list_id"))
                                    DataAccount.followed_user_list_id = res.getInt("followed_user_list_id");
                                if (!res.isNull("user_activation_id"))
                                    DataAccount.user_activation_id = res.getInt("user_activation_id");
                                if (!res.isNull("provider"))
                                    DataAccount.provider = res.getString("provider");
                                if (!res.isNull("uid"))
                                    DataAccount.uid = res.getString("uid");
                                if (!res.isNull("created_at")) {
                                    //String dated = res.getString("created_at");
                                }

                                Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(MainLogin.this, Home.class);
                                startActivity(i);
                                MainLogin.this.finish();
                            }
                            else {
                                String esrror = res.getString("meta");
                                Toast.makeText(getApplicationContext(), esrror, Toast.LENGTH_SHORT).show();
                            }
                        }
                        catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Wrong username and password", Toast.LENGTH_SHORT).show();
                            System.out.println("[ERR] "+ e.getMessage().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println(t.getMessage().toString());
                    }
                });
            }
        });
    }
}
