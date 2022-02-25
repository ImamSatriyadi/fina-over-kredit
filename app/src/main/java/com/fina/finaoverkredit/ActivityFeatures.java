package com.fina.finaoverkredit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Constraints;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class ActivityFeatures extends AppCompatActivity {
    private Dialog dialog;
    private LayoutInflater layoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        dialog               = new Dialog(ActivityFeatures.this, R.style.FullWidth_Dialog);
    }

    public void toOverKredit(View view) {
        alertDialog();
    }

    void alertDialog(){

        dialog.setContentView(R.layout.form_no_kontrak);
        dialog.setCancelable(true);
        Window window   = dialog.getWindow();
        WindowManager.LayoutParams wlp= window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);
        dialog.show();

        layoutInflater  = getLayoutInflater();
        View layout     = layoutInflater.inflate(R.layout.form_no_kontrak, findViewById(R.id.formnokontrak));
        Button kirim    = (Button) dialog.findViewById(R.id.kirimNoKontrak);
        kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tes", "success");
                Intent intent  = new Intent(ActivityFeatures.this, ActivityWebViewOverKredit.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });

    }
}