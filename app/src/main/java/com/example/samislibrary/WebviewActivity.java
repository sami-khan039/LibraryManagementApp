package com.example.samislibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {
WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        wv=findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("https://web.facebook.com/profile.php?id=100014955515688");
    }
}