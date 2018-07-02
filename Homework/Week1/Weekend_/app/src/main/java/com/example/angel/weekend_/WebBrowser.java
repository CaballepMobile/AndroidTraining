package com.example.angel.weekend_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class WebBrowser extends AppCompatActivity {

    private WebView webView;
    private TextView tvOpenUrl;
    private EditText etNewUrl;
    private Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        webView = findViewById(R.id.wvWindow);
        tvOpenUrl = findViewById(R.id.tvOpenUrl);
        etNewUrl = findViewById(R.id.etNewUrl);
        btnSearch = findViewById(R.id.btnSearch);

        webView.setWebViewClient(new WebViewClient());

        String googleUrl = "http://google.com";
        webView.loadUrl(googleUrl);
        tvOpenUrl.setText(googleUrl);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String urlUserInput = etNewUrl.getText().toString();
                    if(!urlUserInput.contains("http://")) {
                        urlUserInput = "http://" + urlUserInput;
                    }

                    webView.loadUrl(urlUserInput);
                    tvOpenUrl.setText(urlUserInput);
                }catch(Exception e){
                    Toast.makeText(WebBrowser.this, "Invalid Url!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
