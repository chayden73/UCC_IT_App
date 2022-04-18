package com.example.uccitapp

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uccitapp.RecyclerViewAdapter.TimeTableViewHolder.TimeTableModel
import java.util.logging.Logger

class TimeTable : AppCompatActivity() {

    //Array of timetable for courses
    var timeTable = arrayListOf(
        TimeTableModel("ENG102", "Introduction to Literature", "M", "2:00PM", "4:00PM"),
        TimeTableModel("ENG102", "Introduction to Literature", "M", "6:00PM", "8:00PM"),
        TimeTableModel("ENG102", "Introduction to Literature", "W", "6:00PM", "8:00PM"),
        TimeTableModel("ENG102", "Introduction to Literature", "Th", "9:00AM", "11:00AM"),
        TimeTableModel("ENG102", "Introduction to Literature", "Th", "12:00PM", "2:00PM"),
        TimeTableModel("ENG102", "Introduction to Literature", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("ENG109", "Academic Writing I", "Su", "12:00PM", "2:00PM"),
        TimeTableModel("ENG109", "Academic Writing I", "Tu", "12:00PM", "2:00PM"),
        TimeTableModel("ENG109", "Academic Writing I", "Tu", "3:00PM", "5:00PM"),
        TimeTableModel("ENG109", "Academic Writing I", "Tu", "6:00PM", "8:00PM"),
        TimeTableModel("ENG109", "Academic Writing I", "W", "6:00PM", "8:00PM"),
        TimeTableModel("ENG109", "Academic Writing I", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "Su", "4:00PM", "6:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "M", "2:30PM", "4:30PM"),
        TimeTableModel("ENG110", "Academic Writing II", "M", "6:00PM", "8:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "Tu", "12:00PM", "2:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "Tu", "2:00PM", "4:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "Tu", "6:00PM", "8:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "W", "6:00PM", "8:00PM"),
        TimeTableModel("ENG110", "Academic Writing II", "Th", "2:30PM", "4:30PM"),
        TimeTableModel("ENG110", "Academic Writing II", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "TBA", "5:30PM", "8:45PM"),
        TimeTableModel("ENG111", "Public Speaking", "Su", "12:00PM", "2:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "M", "3:00PM", "5:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "M", "6:00PM", "8:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "Tu", "3:00PM", "5:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "W", "3:00PM", "5:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "W", "6:00PM", "8:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "Th", "3:00PM", "5:00PM"),
        TimeTableModel("ENG111", "Public Speaking", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "Su", "1:00PM", "4:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "M", "6:00PM", "9:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "Tu", "7:00AM", "10:00AM"),
        TimeTableModel("ITT101", "Computer Information Systems", "Tu", "10:00AM", "1:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "Tu", "6:00PM", "9:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "W", "6:00PM", "9:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "Th", "6:00PM", "9:00PM"),
        TimeTableModel("ITT101", "Computer Information Systems", "Sa", "6:00PM", "9:00PM"),
        TimeTableModel("ITT102", "Discrete Mathematics I", "M", "10:00AM", "12:00PM"),
        TimeTableModel("ITT103", "Programming Techniques", "M", "2:00PM", "4:00PM"),
        TimeTableModel("ITT103", "Programming Techniques", "Tu", "6:00PM", "8:00PM"),
        TimeTableModel("ITT116", "Computer Essentials & Troubleshooting I", "W", "2:00PM", "4:00PM"),
        TimeTableModel("ITT116", "Computer Essentials & Troubleshooting I", "W", "6:00PM", "8:00PM"),
        TimeTableModel("ITT200", "Object Oriented Programming Using C++", "Su", "4:00PM", "6:00PM"),
        TimeTableModel("ITT200", "Object Oriented Programming Using C++", "Th", "12:00PM", "2:00PM"),
        TimeTableModel("ITT201", "Data Communications & Networks I", "M", "6:00PM", "8:00PM"),
        TimeTableModel("ITT203", "Data Structures & File Management I", "Tu", "8:00AM", "10:00AM"),
        TimeTableModel("ITT208", "Internet Authoring I", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("ITT209", "Building Applications with C#", "Th", "8:00PM", "10:00PM"),
        TimeTableModel("ITT210", "Database Management Systems", "Tu", "8:00PM", "10:00PM"),
        TimeTableModel("ITT211", "Computer Data Analysis", "M", "7:00AM", "9:00AM"),
        TimeTableModel("ITT211", "Computer Data Analysis", "Th", "8:00PM", "10:00PM"),
        TimeTableModel("ITT216", "Computer Essentials & Troubleshooting II", "W", "8:00AM", "10:00AM"),
        TimeTableModel("ITT300", "Discrete Mathematics II", "Sa", "8:00PM", "10:00PM"),
        TimeTableModel("ITT301", "Data Structures & File Management II", "M", "8:00PM", "10:00PM"),
        TimeTableModel("ITT302", "Operating Systems", "Tu", "8:00PM", "10:00PM"),
        TimeTableModel("ITT303", "Programming Design Using Java", "Su", "6:00PM", "8:00PM"),
        TimeTableModel("ITT307", "Internet Authoring II", "Th", "8:00PM", "10:00PM"),
        TimeTableModel("ITT309", "Computer Security", "Su", "12:00PM", "2:00PM"),
        TimeTableModel("ITT312", "Introduction to Robotics", "Su", "4:00PM", "6:00PM"),
        TimeTableModel("ITT318", "Cloud Computing", "Su", "3:00PM", "5:00PM"),
        TimeTableModel("ITT323", "IT Capstone Project I", "Th", "8:00PM", "10:00PM"),
        TimeTableModel("ITT403", "Data Communications & Networks II", "M", "6:00PM", "8:00PM"),
        TimeTableModel("ITT405", "Human Computer Interaction & Interface Design", "W", "8:00PM", "10:00PM"),
        TimeTableModel("ITT408", "Information Assurance and Security", "W", "6:00PM", "8:00PM"),
        TimeTableModel("ITT411", "Project+", "W", "8:00PM", "10:00PM"),
        TimeTableModel("ITT420", "Mobile Application Development", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("ITT422", "Cyber Security Analysis+", "Su", "10:00AM", "12:00PM"),
        TimeTableModel("ITT423", "IT Capstone Project II", "Sa", "6:00PM", "8:00PM"),
        TimeTableModel("MKT201", "Principles of Marketing", "TBA", "6:00PM", "8:00PM"),
        TimeTableModel("MKT201", "Principles of Marketing", "Su", "4:00PM", "6:00PM"),
        TimeTableModel("MKT201", "Principles of Marketing", "M", "3:00PM", "5:00PM"),
        TimeTableModel("MKT201", "Principles of Marketing", "Tu", "6:00PM", "8:00PM"),
        TimeTableModel("MKT201", "Principles of Marketing", "W", "7:00AM", "9:00AM"),
        TimeTableModel("MTH101", "College Algebra", "TBA", "6:00PM", "8:00PM"),
        TimeTableModel("MTH101", "College Algebra", "Su", "12:00PM", "2:00PM"),
        TimeTableModel("MTH101", "College Algebra", "M", "8:30PM", "10:30PM"),
        TimeTableModel("MTH101", "College Algebra", "W", "8:30PM", "10:30PM"),
        TimeTableModel("MTH101", "College Algebra", "Th", "3:00PM", "5:00PM"),
        TimeTableModel("MTH103", "Calculus I", "TBA", "6:00PM", "8:00PM"),
        TimeTableModel("MTH103", "Calculus I", "M", "6:00PM", "8:00PM"),
        TimeTableModel("MTH103", "Calculus I", "Tu", "2:00PM", "4:00PM"),
        TimeTableModel("MTH103", "Calculus I", "Th", "8:30PM", "10:30PM"),
        TimeTableModel("POL100", "Introduction to Politics", "TBA", "6:00PM", "8:00PM"),
        TimeTableModel("POL100", "Introduction to Politics", "Su", "12:00PM", "2:00PM"),
        TimeTableModel("POL100", "Introduction to Politics", "M", "2:30PM", "4:30PM"),
        TimeTableModel("POL100", "Introduction to Politics", "M", "6:00PM", "8:00PM"),
        TimeTableModel("POL100", "Introduction to Politics", "Tu", "12:00PM", "2:00PM"),
        TimeTableModel("POL100", "Introduction to Politics", "W", "6:00PM", "8:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "TBA", "5:00PM", "10:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "TBA", "6:00PM", "8:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "Su", "4:00PM", "6:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "M", "10:00AM", "12:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "Tu", "6:00PM", "8:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "W", "9:00AM", "11:00AM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "W", "11:30AM", "1:30PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "W", "6:00PM", "8:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "Th", "12:30PM", "2:30PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "Th", "6:00PM", "8:00PM"),
        TimeTableModel("PSY100", "Introduction to Psychology", "Th", "8:30PM", "10:30PM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "TBA", "5:30PM", "8:45PM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "TBA", "6:00PM", "8:00PM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "Su", "4:00PM", "6:00PM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "Tu", "9:00AM", "11:00AM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "Tu", "6:00PM", "8:00PM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "W", "6:00PM", "8:00PM"),
        TimeTableModel("SOC100", "Introduction to Sociology", "Th", "3:30PM", "5:30PM"),
        TimeTableModel("SPA101", "Introduction to Spanish", "Su", "2:00PM", "4:00PM"),
        TimeTableModel("SPA101", "Introduction to Spanish", "M", "12:00PM", "2:00PM"),
        TimeTableModel("SPA101", "Introduction to Spanish", "M", "6:00PM", "8:00PM"),
        TimeTableModel("SPA101", "Introduction to Spanish", "W", "6:00PM", "8:00PM"),
        TimeTableModel("UCC101", "Orientation to University Life", "Su", "6:00PM", "8:00PM"),
        TimeTableModel("UCC101", "Orientation to University Life", "TuW", "2:00PM", "3:00PM"),
        TimeTableModel("UCC101", "Orientation to University Life", "W", "6:00PM", "8:00PM"),
        TimeTableModel("UCC101", "Orientation to University Life", "F", "9:00AM", "11:00AM"),
        TimeTableModel("UCC101", "Orientation to University Life", "F", "11:30AM", "1:30PM")
    )



    var spinner: Spinner? = null
    private var spinnerAdapter: ArrayAdapter<String>? = null
    var recyclerview: RecyclerView? = null
    private var recycleriewAdapter: RecyclerViewAdapter? = null

    //Array of list of courses for spinner
    var courses = arrayOf("All",
        "Academic Writing I",
        "Academic Writing II",
        "Building Applications with C#",
        "Calculus I",
        "Cloud Computing",
        "College Algebra",
        "Computer Data Analysis",
        "Computer Essentials & Troubleshooting I",
        "Computer Essentials & Troubleshooting II",
        "Computer Information Systems",
        "Computer Security",
        "Cyber Security Analysis+",
        "Data Communications & Networks I",
        "Data Communications & Networks II",
        "Data Structures & File Management I",
        "Data Structures & File Management II",
        "Database Management Systems",
        "Discrete Mathematics I",
        "Discrete Mathematics II",
        "Human Computer Interaction & Interface Design",
        "Information Assurance and Security",
        "Internet Authoring I",
        "Internet Authoring II",
        "Introduction to Literature",
        "Introduction to Politics",
        "Introduction to Psychology",
        "Introduction to Robotics",
        "Introduction to Sociology",
        "Introduction to Spanish",
        "IT Capstone Project I",
        "IT Capstone Project II",
        "Mobile Application Development",
        "Object Oriented Programming Using C++",
        "Operating Systems",
        "Orientation to University Life",
        "Principles of Marketing",
        "Programming Design Using Java",
        "Programming Techniques",
        "Project+",
        "Public Speaking"
    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table)
        initializeView()

    }

    private fun initializeView(){

        spinnerAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,courses)
        spinner = findViewById(R.id.spCourses)
        spinner?.adapter = spinnerAdapter

        recyclerview = findViewById(R.id.rvCourses)
        recyclerview?.layoutManager = LinearLayoutManager(this)
        recycleriewAdapter = RecyclerViewAdapter()
        recyclerview?.adapter = recycleriewAdapter
        recycleriewAdapter!!.addCourses(timeTable)


        spinner?.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                if (position >= 0 && position < courses.size) {
                    var selCourses:ArrayList<RecyclerViewAdapter.TimeTableViewHolder.TimeTableModel> = ArrayList()

                    Log.e("My Course TimeTable: ", position.toString())
                        if (position == 0) {
                            recycleriewAdapter!!.addCourses(timeTable)
                        } else {

                        Log.e("My Course TimeTable: ", courses[position])
                            for (courseName in timeTable) {

                                if (courseName.trName == courses[position]) {
                                    selCourses.add(courseName)
                                }
                            }
                            recycleriewAdapter!!.addCourses(selCourses)
                        }

                } else {
                     Toast.makeText(
                        this@TimeTable,
                        "Selected Course Does not Exist!",
                        Toast.LENGTH_SHORT
                    ).show()


                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        )





    }


}




class RecyclerViewAdapter():RecyclerView.Adapter<RecyclerViewAdapter.TimeTableViewHolder>() {
    private var course:ArrayList<TimeTableViewHolder.TimeTableModel> = ArrayList()

    fun addCourses(timeList:ArrayList<TimeTableViewHolder.TimeTableModel> ){
        this.course = timeList
        notifyDataSetChanged()
    }



class TimeTableViewHolder(var view: View):RecyclerView.ViewHolder(view){
    private var trCode = view.findViewById<TextView>(R.id.tvCode)
    private  var trName = view.findViewById<TextView>(R.id.tvName2)
    private var trDay = view.findViewById<TextView>(R.id.tvDay)
    private var trStart = view.findViewById<TextView>(R.id.tvStart)
    private var trEnd = view.findViewById<TextView>(R.id.tvEnd)

    fun bindView(course:TimeTableModel){
        trCode.text = course.trCode.toString()
        trName.text = course.trName.toString()
        trDay.text = course.trDay.toString()
        trStart.text = course.trStart.toString()
        trEnd.text = course.trEnd.toString()

    }

    class TimeTableModel {
        var trCode = ""
        var trName = ""
        var trDay = ""
        var trStart = ""
        var trEnd = ""


        constructor(trCode: String, trName: String, trDay: String, trStart: String, trEnd: String) {
            this.trCode = trCode
            this.trName = trName
            this.trDay = trDay
            this.trStart = trStart
            this.trEnd = trEnd
        }
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecyclerViewAdapter.TimeTableViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_time_table_detail, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerViewAdapter.TimeTableViewHolder, position: Int) {
        val course = course[position]
        holder.bindView(course)
    }

    override fun getItemCount(): Int {
        return course.size
    }
}
