package com.example.uccitapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLDBHelper(
    context: Context?
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ucc_it.db"
        private const val TBL_COURSES = "tbl_courses"
        private val CODE  = "code"
        private val NAME = "name"
        private val CREDITS  = "credits"
        private val PREREQUISITES  = "prerequisites"
        private val DESCRIPTION  = "description"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblTextbook = ("CREATE TABLE " + TBL_COURSES + "("
                + CODE + " TEXT PRIMARY KEY, " + NAME + " TEXT, "
                + CREDITS + " TEXT, " + PREREQUISITES + " TEXT, " + DESCRIPTION + " TEXT)")
        db?.execSQL(createTblTextbook)
        insertCourses(db)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_COURSES")
    }

    fun insertCourses(db: SQLiteDatabase?){

        //Create SQL to insert courses into database
        val contentValues = "INSERT INTO tbl_courses(code, name, credits, prerequisites, description)\t\n" +
                "VALUES (\"ITT101\", \"Computer Information Systems\", \"3\", \"None\", \"This introductory course provides the necessary background for understanding the role of information systems in organisations and for using computer tools and technology in solving business problems. The main concepts covered include: types and categories of computers; software and hardware components; storage; computer networks; and operating systems, with an emphasis on analysing problems and creating solutions. In the practical section of the course, you will gain hands-on experience using Office productivity tools.\"), \n" +
                "(\"ITT211\", \"Computer Data Analysis\", \"3\", \"None\", \"This is an introductory course that allows you to format, calculate, and analyse data. The course will equip you with the skills needed to use a spreadsheet and python programs. Topics include: numerical and graphical summaries of data; hypothesis testing; confidence intervals; counts and tables; analysis of variance; regression; principal components; and cluster analysis. Upon completion of this course, you should be able to think critically about data and apply standard statistical inference procedures to draw conclusions from such analyses. \"), \n" +
                "(\"SOC100\", \"Introduction to Sociology\", \"3\", \"None\", \"This introductory course seeks to provide an overview of sociology as a discipline. It lays the foundation for you to apply the various theoretical perspectives to contemporary social problems, especially relating to the world of work.\"), \n" +
                "(\"ITT420\", \"Mobile Application Development\", \"3\", \"None\", \"This course will introduce you to the core conceptual skills and basic practices needed to develop an Android application. The course will focus on how the application communicates to retrieve, store and interact with other devices on any android platform. Topics will include memory management, user interface design, user interface building, input methods, data handling, and network techniques.\"), \n" +
                "(\"PSY100\", \"Introduction to Psychology\", \"3\", \"None\", \"This introductory course in psychology is designed to give you a basic understanding of human behaviour. You will learn the major psychological theories that will allow you to explain and predict human behaviour. The emphasis will be on examining your behaviour and the behaviour of others within an organisational context.\"), \n" +
                "(\"ITT302\", \"Operating Systems\", \"3\", \"ITT200 Object Oriented Programming using C++,\", \"The course introduces the fundamentals of operating systems design and implementation. Topics include an overview of the components of an operating system, mutual exclusion and synchronisation, implementation of processes, scheduling algorithms, memory management, and file systems. The course explains the issues and influence of the contemporary operating systems designs and may include a laboratory component to enable you to experiment with operating systems.\"), \n" +
                "(\"ITT102\", \"Discrete Mathematics I\", \"3\", \"MTH101 College Algebra\", \"This course will introduce you to the basic idea of how computer systems are designed and will provide a realistic picture of the internal workings and design of computer systems.\"), \n" +
                "(\"ENG110\", \"Academic Writing II\", \"3\", \"ENG109 Academic Writing I\", \"This module is an introduction to the analysis of critical thinking. The module aims to impart a skill in the ability to recognise and to construct common types of cogent and non-cogent reasoning in a structured and written way.\"), \n" +
                "(\"ENG111\", \"Public Speaking\", \"3\", \"ENG109 Academic Writing I\", \"The course is designed to integrate theory and practice in preparing professionals for public speaking assignments. You will be provided with the opportunity to develop skills in the preparation and delivery of speeches for specific types of professional occasions.\"),\n" +
                "(\"ENG109\", \"Academic Writing I\", \"3\", \"ENG002 English for Academic Purposes/CSEC English A (Grade 1 or 2)\", \"This is a writing course focusing on expository writings. Basic editing principles are covered and applied to all writing. Selected essays are read and examined as examples of the expository styles to improve critical reading skills, grammar skills, and essay writing. Research techniques and documentation are also emphasised as methods to enhance writing.\")\n" +
                ";"
        db?.execSQL(contentValues)
    }

    fun getAllCourses(): ArrayList<CourseModel>{
        val courseList : ArrayList<CourseModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_COURSES"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery,null)
        } catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()


        }

        var code :String
        var name : String
        var credits : String
        var prerequisites : String
        var description : String


        if(cursor.moveToFirst()){
            do {
                code = cursor.getString(cursor.getColumnIndex("code"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                credits = cursor.getString(cursor.getColumnIndex("credits"))
                prerequisites = cursor.getString(cursor.getColumnIndex("prerequisites"))
                description = cursor.getString(cursor.getColumnIndex("description"))

                val course = CourseModel(code, name, credits, prerequisites, description)
                courseList.add(course)

            } while (cursor.moveToNext())
        }
        return courseList
    }


}