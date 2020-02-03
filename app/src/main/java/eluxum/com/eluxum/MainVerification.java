package eluxum.com.eluxum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainVerification extends AppCompatActivity {
    TextView appResend;
    Button appFinishReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        appFinishReg = findViewById(R.id.btn_forgotpass);
        appResend = findViewById(R.id.btn_resend);

        appFinishReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainVerification.this, MainActivity.class);
                startActivity(i);
                MainVerification.this.finish();
            }
        });


    }
}
