package eluxum.com.eluxum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {

    Button appLogin, appRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appLogin = findViewById(R.id.bMenuLogin);
        appRegister = findViewById(R.id.bMenuRegister);

        appLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainLogin.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        });

        appRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainRegister.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        });

    }
}
