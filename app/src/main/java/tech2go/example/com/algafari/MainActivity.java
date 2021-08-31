package tech2go.example.com.algafari;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       /* final RecyclerView postRecycler = (RecyclerView) findViewById(R.id.post_recycler);
        postRecycler.setLayoutManager(new LinearLayoutManager(this));
        List<Post> posts = new ArrayList<>();
        int[] sections_id = {R.drawable.ic_algafari_large, R.drawable.ic_algafari_large, R.drawable.ic_algafari_large};
        for (int i = 0; i < sections_id.length; i++) {
            Post post = new Post(sections_id[i]);
            posts.add(post);
            // Toast.makeText(getBaseContext(),""+posts.get(i),Toast.LENGTH_LONG).show();
            PostAdapter postAdapter = new PostAdapter(posts,MainActivity.this);
            postRecycler.setAdapter(postAdapter);
        }*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*FloatingActionButton actionButton = (FloatingActionButton) drawer.findViewById(R.id.add_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
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
        });*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        changeView(R.id.nav_home);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please double tab to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    private void changeView(int id){
        Fragment fragment = null;
        switch (id){
            case R.id.nav_home:
                fragment=new LibraryFragment();
                break;
            case R.id.nav_services:
                fragment=new ServicesFragment();
                break;
            case R.id.nav_clients:
                fragment=new ClientsFragment();
                break;
            case R.id.nav_projects:
                fragment=new ProjectsFragment();
                break;
            case R.id.nav_certificates:
                fragment=new CertificatesFragment();
                break;
            case R.id.nav_qhse:
                fragment=new QHSEFragment();
                break;
            case R.id.nav_contact:
                fragment=new ContactusFragment();
                break;
            case R.id.nav_about:
                fragment=new AboutFragment();

                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fragment_enter_left,R.anim.fragment_exit_right);
            fragmentTransaction.replace(R.id.content_main,fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

   /*     if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        changeView(id);

        return true;
    }
}
