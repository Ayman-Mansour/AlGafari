package tech2go.example.com.algafari;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Splash extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    protected void onCreate(Bundle paramBundle) {

        super.onCreate(paramBundle);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        new Handler().postDelayed(new Runnable() {

                                      public void run() {
                                          Intent localIntent = new Intent(Splash.this, MainActivity.class);
                                          Splash.this.startActivity(localIntent);
                                          Splash.this.finish();
                                      }
                                  }
                , SPLASH_TIME_OUT);
    }
}