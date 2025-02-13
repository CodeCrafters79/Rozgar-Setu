package it.dtech.rozgarsetu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize Views
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);

        // Setup Toolbar
        setSupportActionBar(toolbar);

        // Enable Toggle for Drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle Navigation Drawer Item Clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show();
                // Navigate to Home Activity (if exists)
                Intent intent = new Intent(Dashboard.this, Dashboard.class);
                startActivity(intent);
            } else if (id == R.id.nav_settings) {
//                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Dashboard.this, SettingsActivity.class);
//                startActivity(intent);
            } else if (id == R.id.nav_logout) {
                Toast.makeText(this, "Logging Out...", Toast.LENGTH_SHORT).show();
                // Handle logout logic (clear session, redirect to login)
                Intent intent = new Intent(Dashboard.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
            drawerLayout.closeDrawers();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
//            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(Dashboard.this, SettingsActivity.class);
//            startActivity(intent);
//            return true;
        } else if (id == R.id.action_about) {
            Toast.makeText(this, "About Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Dashboard.this, AboutUs.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
