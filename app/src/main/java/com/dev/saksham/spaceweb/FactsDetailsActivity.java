package com.dev.saksham.spaceweb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;

public class FactsDetailsActivity extends AppCompatActivity {
    String[] urls={"https://space-facts.com/the-sun/","https://space-facts.com/the-moon/",
            "https://space-facts.com/mercury/","https://space-facts.com/venus/",
            "https://space-facts.com/earth/","https://space-facts.com/mars/",
            "https://space-facts.com/jupiter/","https://space-facts.com/saturn/",
            "https://space-facts.com/uranus/","https://space-facts.com/asteroids/",
            "https://space-facts.com/meteorites/"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.factsdetails);
        Intent i = getIntent();        // Selected image id
        int position = i.getExtras().getInt("id");
        WebView mywebview = (WebView) findViewById(R.id.webView);
        // mywebview.loadUrl("https://www.javatpoint.com/");

        /*String data = "<html><body><h1>Hello, Javatpoint!</h1></body></html>";
        mywebview.loadData(data, "text/html", "UTF-8"); */

        mywebview.loadUrl(urls[position]);
       // imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
}