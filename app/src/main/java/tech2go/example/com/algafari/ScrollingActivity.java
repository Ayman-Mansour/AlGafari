package tech2go.example.com.algafari;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.transition));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        /*setSupportActionBar((Toolbar) toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        TextView textView = (TextView) findViewById(R.id.awareness_detail);
        ImageView imageView = (ImageView) findViewById(R.id.awareness_image);
        setSupportActionBar(toolbar);
        Intent i = getIntent();
        Bundle a = i.getExtras();
        String menuh1 = "awareness_x1";
        String menuh2 = "awareness_x2";
        String menu1 = "awareness_1";
        String menu2 = "awareness_2";
        String menu3 = "awareness_3";
        String menu4 = "awareness_4";
        String menu5 = "awareness_5";
        String menu6 = "awareness_6";
        String menu7 = "awareness_7";
        String menu8 = "awareness_8";
        if (a.containsKey(menu1)) {
            textView.setText(R.string.infrastructure_des);
           /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");

              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
//                supportPostponeEnterTransition();
            }*/
            imageView.setImageResource(R.drawable.infrastructure_sys);
            setCollapsingToolbarLayoutTitle("Infrastructure Solutions");

    }else if(a.containsKey(menu2)) {
            textView.setText(R.string.construction_des);
          /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");

              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
//                supportPostponeEnterTransition();
            }*/
            imageView.setImageResource(R.drawable.construction);
            setCollapsingToolbarLayoutTitle("Construction Solutions");
        }else if(a.containsKey(menu3)) {
            textView.setText(R.string.hvac_des);
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");

              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
//                supportPostponeEnterTransition();
            }*/
            imageView.setImageResource(R.drawable.syssolution);
            setCollapsingToolbarLayoutTitle("HVAC Systems Solutions");
        }else if(a.containsKey(menu4)) {
            textView.setText(R.string.fire_protection_des);
           /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" );
              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
//                supportPostponeEnterTransition();
            }*/
            imageView.setImageResource(R.drawable.fire_protection);
            setCollapsingToolbarLayoutTitle("Fire protection Systems Solution");
        }else if(a.containsKey(menu5)) {
            textView.setText(R.string.electrical_des);
           /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");
              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
//                supportPostponeEnterTransition();
            }*/
            imageView.setImageResource(R.drawable.electrical_sys);
            setCollapsingToolbarLayoutTitle("Electrical Systems Solutions");
        }else if(a.containsKey(menu6)) {
            textView.setText(R.string.plumbing_des);
           /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");
              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
            }*/
            imageView.setImageResource(R.drawable.plumbing_sys);
            setCollapsingToolbarLayoutTitle("Plumbing Systems Solutions");
        }else if(a.containsKey(menu7)) {
            textView.setText(R.string.security_des);
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");
              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
            }*/
            imageView.setImageResource(R.drawable.security_sys);
            setCollapsingToolbarLayoutTitle("Security Systems Solutions");
        }else if(a.containsKey(menu8)) {
            textView.setText(R.string.networking_des);
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");
              //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
            }*/
            imageView.setImageResource(R.drawable.network_sys);
            setCollapsingToolbarLayoutTitle("Networking Systems Solutions");
        }else if(a.containsKey(menuh1)) {
            textView.setText(R.string.lightning_des);
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");
                //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
            }*/
            imageView.setImageResource(R.drawable.lightining);
            setCollapsingToolbarLayoutTitle("Lightning Systems Solutions");
        }else if(a.containsKey(menuh2)) {
            textView.setText(R.string.low_current_des);
           /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                imageView.setTransitionName("accidant" + "0");
                //  Toast.makeText(getBaseContext(), imageView.getTransitionName(), Toast.LENGTH_LONG).show();
            }*/
            imageView.setImageResource(R.drawable.low_current);
            setCollapsingToolbarLayoutTitle("Low Current Solutions");
        }
}
    private void setCollapsingToolbarLayoutTitle(String title) {
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(title);
        mCollapsingToolbarLayout.setCollapsedTitleGravity(View.TEXT_ALIGNMENT_GRAVITY);
//        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
//        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
//        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
//        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }


        return super.onOptionsItemSelected(item);
    }
}
