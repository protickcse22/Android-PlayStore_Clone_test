package com.softbd.googleplaystoreclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private SearchView searchView;
    private MyRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_humberger);

        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        GamesFragment fragment = new GamesFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameContainerForGames, fragment).commit();

        AppsFragment appsFragment = new AppsFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameContainerForApps, appsFragment).commit();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                AppsFragment.adapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.notificationMyAppsItem:
                Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Notification()).commit();
                break;
            case R.id.myAppsItem:
                Toast.makeText(getApplicationContext(), "My app & games", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                Intent i = new Intent(MainActivity.this, AppsAndGamesActivity.class);
                startActivity(i);
                break;
            case R.id.subscriptionMyAppsItem:
                Toast.makeText(getApplicationContext(), "Subscription", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Subscriptions()).commit();
                break;
            case R.id.wishListItem:
                Toast.makeText(getApplicationContext(), "wishList", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Wishlist()).commit();
                break;

            case R.id.settingsItem:
                Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new Settings()).commit();
                break;

        }

        return true;
    }
}
