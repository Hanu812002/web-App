package com.Hanu.webviewdemo;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // window fullscreen
        Window w=getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //taking access of button
        b1=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);


       // when button is clicked then this function is performed
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //entered url is taken into user defined string
                String url = ed1.getText().toString();
                //checking whether entered url is valid or not
                if(URLUtil.isValidUrl(url))
                  switchActivities(url);
                else
                    Toast.makeText(MainActivity.this, "Invalid URL", Toast.LENGTH_SHORT).show();
            }
        });

    }
//If entered url is valid then through intent is redirected to another activity where webview is used
    private void switchActivities(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("key1", url);

        Intent switchActivityIntent = new Intent(this, webview.class);
        switchActivityIntent.putExtras(bundle);
        startActivity(switchActivityIntent);
    }


}



    // Additional code.

