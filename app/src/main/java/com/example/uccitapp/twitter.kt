package com.example.uccitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class twitter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter)

        val twitterweb: WebView = findViewById(R.id.wvTwitter)
        val webSettings = twitterweb.settings
        webSettings.javaScriptEnabled = true

        twitterweb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        twitterweb.loadUrl("https://twitter.com/uccjamaica")

    }
}