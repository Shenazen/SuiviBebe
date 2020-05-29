package fr.leuridan.suivi;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.NoCopySpan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        SystemClock.sleep(2000);
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
