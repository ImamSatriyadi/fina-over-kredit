package com.fina.finaoverkredit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    private Button btnLogin;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private LoadingDialog loadingDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        }
        loadingDialog       = new LoadingDialog(this);
        btnLogin            = findViewById(R.id.btnLogin);
        editTextEmail       = findViewById(R.id.editTextEmailInput);
        editTextPassword    = findViewById(R.id.editTextPasswordInput);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth();
            }
        });

    }

    public void auth(){
        String email    = editTextEmail.getText().toString();
        String pass     = editTextPassword.getText().toString();
        if(email.isEmpty()){
            editTextEmail.setError("Email Is Required");
        }
        else if(pass.isEmpty()){
            editTextPassword.setError("Password is required");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Email Invalid");
        }
        else {
            if(email.equals("imamsatriyadi.kunir.it@gmail.com") && pass.equals("imam18")){
                SharedPreferences.Editor editor = getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit();
                editor.putString("email", email);
                editor.commit();
                Handler handler = new Handler();
                loadingDialog.startLoading();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissLoading();
                        Intent intent = new Intent(ActivityLogin.this, ActivityHome.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);

            }
            else{
                Toast.makeText(this, "Email or Password is Invalid", Toast.LENGTH_SHORT).show();
            }
        }
    }
}