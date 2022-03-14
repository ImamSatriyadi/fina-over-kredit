package com.fina.finaoverkredit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
    }

    public void toHome(View view) {
        Intent intent   = new Intent(ActivityArticle.this, ActivityHome.class);
        startActivity(intent);
        finish();
    }
}