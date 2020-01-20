package eluxum.com.eluxum;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainRegister extends AppCompatActivity {
    Button appGotoVer;
    CheckBox appToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        appGotoVer = findViewById(R.id.btn_signup);
        appToggle = findViewById(R.id.toggleBtn);

        appGotoVer.setEnabled(false);

        appToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (appToggle.isChecked()) {
                    appGotoVer.setEnabled(true);
                    appGotoVer.setBackgroundResource(R.drawable.ar_button);
                }
                else {
                    appGotoVer.setEnabled(false);
                    appGotoVer.setBackgroundResource(R.drawable.ar_button_disabled);
                }
            }
        });

        appGotoVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRegister.this, MainVerification.class);
                startActivity(i);
                MainRegister.this.finish();
            }
        });
    }
}
