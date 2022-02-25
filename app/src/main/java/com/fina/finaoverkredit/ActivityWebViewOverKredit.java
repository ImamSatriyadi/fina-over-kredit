package com.fina.finaoverkredit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWebViewOverKredit extends AppCompatActivity {
    private WebView web;
    private LoadingDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_over_kredit);
        web     =  (WebView) findViewById(R.id.web);
        loading = new LoadingDialog(this);

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setAppCacheEnabled(true);
        web.getSettings().setAllowFileAccess(true);
        web.loadUrl("https://fina-overkredit.herokuapp.com");
        loading.startLoading();
        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loading.dismissLoading();
            }
        });
    }
}