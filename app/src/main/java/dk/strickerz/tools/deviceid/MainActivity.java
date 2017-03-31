package dk.strickerz.tools.deviceid;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String device_id;
    private TextView device_id_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        device_id_tv = (TextView)findViewById(R.id.deviceIdTxtView);
        device_id_tv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in));
        device_id_tv.setText(device_id);
    }
}
