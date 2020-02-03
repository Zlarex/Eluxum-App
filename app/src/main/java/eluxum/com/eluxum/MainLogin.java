package eluxum.com.eluxum;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainLogin extends AppCompatActivity {

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
                String tPass = tPassword.getText().toString();

                Intent i = new Intent(MainLogin.this, Home.class);
                startActivity(i);
                MainLogin.this.finish();
            }
        });
    }
}
