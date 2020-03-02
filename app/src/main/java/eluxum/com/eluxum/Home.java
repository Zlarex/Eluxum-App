package eluxum.com.eluxum;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        loadFragment(new FragmentHome());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Eluxum");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        BottomNavigationView bnavView = (BottomNavigationView)findViewById(R.id.bottomNav);

        bnavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch(menuItem.getItemId()) {
                    case R.id.Nhome: {
                        fragment = new FragmentHome();
                        break;
                    }
                    case R.id.Nexplore: {
                        fragment = new FragmentExplore();
                        break;
                    }
                    case R.id.Nnotif: {
                        fragment = new FragmentNotif();
                        break;
                    }
                    case R.id.Naccount: {
                        fragment = new FragmentUser();
                        break;
                    }
                }
                return loadFragment(fragment);
            }
        });

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.baseFrame, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        View view = findViewById(R.id.bottomView);
        BottomNavigationView nav = (BottomNavigationView) findViewById(R.id.bottomNav);
        nav.setVisibility(View.GONE);
        view.setVisibility(View.GONE);
        if (id == R.id.item_account) {
            // Handle the camera action
            nav.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
        } else if (id == R.id.item_order) {

        } else if (id == R.id.item_wishlist) {

        } else if (id == R.id.item_history) {

        } else if (id == R.id.item_bussines) {

        } else if (id == R.id.item_logout) {

        } else if (id == R.id.item_support) {

        } else if (id == R.id.item_feedback) {

        } else if (id == R.id.item_privacy) {

        } else if (id == R.id.item_about) {

        } else {
            Toast.makeText(this, "Invalid config, please tell the developer", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
