package com.example.uccitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Courses : AppCompatActivity() {
    lateinit var rvCourses: RecyclerView
    var adapter: CourseAdapter? = null

    var course:CourseModel? = null

    lateinit var sqliteHelper: SQLDBHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        rvCourses = findViewById(R.id.rvCourses)

        rvCourses.layoutManager = LinearLayoutManager(this)

        adapter = CourseAdapter()

        rvCourses.adapter = adapter

        sqliteHelper = SQLDBHelper(this)

        adapter?.addBooks( sqliteHelper.getAllCourses())

    }
}