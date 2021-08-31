package tech2go.example.com.algafari;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        Button facebookBTN = (Button) findViewById(R.id.facebook);
        Button twitterBTN = (Button) findViewById(R.id.twitter);
        Button instagramBTN = (Button) findViewById(R.id.instagram);

        facebookBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                final String urlFb1 = "fb://page/530387500445728";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlFb1));

                // If a Facebook app is installed, use it. Otherwise, launch
                // a browser
                final PackageManager packageManager1 = getPackageManager();
                List<ResolveInfo> list1 =
                        packageManager1.queryIntentActivities(intent,
                                PackageManager.MATCH_DEFAULT_ONLY);
                if (list1.size() == 0) {
                    final String urlBrowser = "https://www.facebook.com/algafarigisco/";
                    intent.setData(Uri.parse(urlBrowser));
                }

                startActivity(intent);
            }
        });

        twitterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SocialActivity.this, "TWITTER !!!", Toast.LENGTH_SHORT).show();
            }
        });

        instagramBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SocialActivity.this, "INSTAGRAM !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
