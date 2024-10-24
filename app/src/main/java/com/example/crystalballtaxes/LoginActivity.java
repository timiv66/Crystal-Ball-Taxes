package com.example.crystalballtaxes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmailInput, loginPassInput;
    private TextView forgetPass;
    private Button loginBtn, signUpBtn;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    //this ignores a false progress bar error
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.loginProgressBar);
        progressBar.setVisibility(View.GONE);

        loginEmailInput = findViewById(R.id.emailEditTxt);
        loginPassInput = findViewById(R.id.passwordEditTxt);

        forgetPass = findViewById(R.id.forgotPassTxt);

        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

    }
}