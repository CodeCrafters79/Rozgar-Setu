package it.dtech.rozgarsetu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Find the app logo
        ImageView appLogo = findViewById(R.id.app_logo);

        // Create fade-in animation
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000); // 2 seconds
        appLogo.startAnimation(fadeIn);

        // Redirect to SignupActivity after animation
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, SignupActivity.class);
            startActivity(intent);
            finish(); // Close SplashActivity
        }, 2500); // Delay slightly longer than animation
    }
}
