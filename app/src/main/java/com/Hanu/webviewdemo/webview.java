package com.sandipbhattacharya.webviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class webview extends AppCompatActivity {
    private WebView wv1;
    @Override


    //this is all webview in which entered url is loaded and all perssions are given linke images and javascript
    protected void onCreate(Bundle savedInstanceState) {
        Window w=getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        wv1=(WebView)findViewById(R.id.webView);
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("key1", "Default");
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(title);
    }
}