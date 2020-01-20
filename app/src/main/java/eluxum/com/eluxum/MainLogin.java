package eluxum.com.eluxum;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;

public class MainLogin extends AppCompatActivity {

    Button bLogin;
    EditText eUsername;
    TextInputEditText tPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = (Button)findViewById(R.id.btn_signin);
        eUsername = (EditText)findViewById(R.id.et_username);
        tPassword = (TextInputEditText)findViewById(R.id.et_tiet);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUser = eUsername.getText().toString();
                String tPass = tPassword.getText().toString();


            }
        });
    }
}
