package br.com.josef.desafiowebservicemarvel.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import br.com.josef.desafiowebservicemarvel.R;

public class SplashActivity extends AppCompatActivity {

    private Timer timer = new Timer();
    private ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splash = findViewById(R.id.imageSplash);

        splash.setOnClickListener(v -> {
            jump();
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        },3000);
    }

    private void jump(){
        timer.cancel();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
