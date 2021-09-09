package org.mercurcodes.androidhook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://192.168.134.81:3000");

        myWebView.addJavascriptInterface(new MyWebViewInterface(this), "MyNewInterface");
        this.myText = (TextView) findViewById(R.id.textView);

        Button myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                WebView myWebView = (WebView) findViewById(R.id.webView);
                myWebView.evaluateJavascript(
                        "window.NachrichtenHook(\" Neue Nachricht\");",
                        null
                );
            }
        });
    }

    protected void changeMessage(final String newMessage) {
        this.myText.setText(newMessage);
    }
}