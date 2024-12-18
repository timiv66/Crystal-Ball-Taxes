package com.example.crystalballtaxes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
            finish();
        });

        Button startBtn = findViewById(R.id.startBtn);
        try {
            startBtn.setOnClickListener(view -> {
                Intent i = new Intent(this, FilingStatusActivity.class);
                startActivity(i);
            });
        }catch (Exception e){
            Log.e("MainActivity", "Error starting FilingStatusActivity", e);
        }
        Button dbBtn = findViewById(R.id.dbBtn);
        try {
            dbBtn.setOnClickListener(view -> {
                Intent i = new Intent(this, DatabaseManagerGuiActivity.class);
                startActivity(i);
            });
            }catch (Exception e){
            Log.e("MainActivity", "Error starting DatabaseManagerGuiActivity", e);
        }


    }

}