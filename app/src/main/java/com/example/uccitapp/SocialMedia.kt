package com.example.uccitapp

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi

class SocialMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        val facebook: ImageView = findViewById(R.id.ivFacebook)
        facebook.setOnClickListener {
            val intent = Intent(this,com.example.uccitapp.facebook::class.java)
            startActivity(intent)
        }

        val twitter: ImageView = findViewById(R.id.ivTwitter)
        twitter.setOnClickListener {
            val intent = Intent(this,com.example.uccitapp.twitter::class.java)
            startActivity(intent)
        }

        val instagram: ImageView = findViewById(R.id.ivInstagram)
        instagram.setOnClickListener {
            val intent = Intent(this,com.example.uccitapp.instagram::class.java)
            startActivity(intent)
        }
    }
}
