package dk.strickerz.tools.deviceid;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

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
        device_id_tv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in));

        device_id_tv.setText(device_id);
    }

    public void copyToClipboard(View v) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("device-id", device_id);

        clipboard.setPrimaryClip(clip);

        Toast toast = Toast.makeText(getApplicationContext(), "Device id copied to clipboard", Toast.LENGTH_SHORT);
        toast.show();
    }
}
