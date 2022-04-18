package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val hodMail: String = "ithod@ucc.edu.jm"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Opens directory activity
        val directory:CardView = findViewById(R.id.cvDirectory)
        directory.setOnClickListener {
            val intent = Intent(this,Directory::class.java)
            startActivity(intent)
        }

        //Opens time table activity
        val timeTable:CardView = findViewById(R.id.cvTimeTable)
        timeTable.setOnClickListener {
            val intent = Intent(this,TimeTable::class.java)
            startActivity(intent)
        }

        //Opens courses activity
        val courses:CardView = findViewById(R.id.cvCourses)
        courses.setOnClickListener {
            val intent = Intent(this,Courses::class.java)
            startActivity(intent)
        }

        //Opens admissions activity
        val admissions:CardView = findViewById(R.id.cvAdmissions)
        admissions.setOnClickListener {
            val intent = Intent(this,Admissions::class.java)
            startActivity(intent)
        }

        //Opens social media activity
        val socialmedia:CardView = findViewById(R.id.cvSocialMedia)
        socialmedia.setOnClickListener {
            val intent = Intent(this,SocialMedia::class.java)
            startActivity(intent)
        }

        //Sends email to head of department when FAB is clicked
        val sendEmail: FloatingActionButton = findViewById(R.id.fabHODEmail)
        sendEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", hodMail, null))
            intent.putExtra(Intent.EXTRA_EMAIL, hodMail)
            startActivity(intent)
        }

    }




}