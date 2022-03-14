package com.fina.finaoverkredit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toOverKredit(View view) {
        Intent intent   = new Intent(ActivityHome.this, ActivityFeatures.class);
        startActivity(intent);
    }

    public void toArticle(View view) {
        Intent intent   = new Intent(ActivityHome.this, ActivityArticle.class);
        startActivity(intent);
    }
}