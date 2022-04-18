package com.example.uccitapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CourseAdapter:RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    private var courseList:ArrayList<CourseModel> = ArrayList()
    private var onClickCourse:((CourseModel)->Unit)? = null


    fun addBooks(books:ArrayList<CourseModel>){
        this.courseList = books
        notifyDataSetChanged()
    }


    class CourseViewHolder(var view: View):RecyclerView.ViewHolder(view){
        private var tvCourse2 = view.findViewById<TextView>(R.id.tvCourse)
        private var tvCredits = view.findViewById<TextView>(R.id.tvCredits)
        private var tvPrereq = view.findViewById<TextView>(R.id.tvPrereq)
        private var tvDescription = view.findViewById<TextView>(R.id.tvDescription)


        fun bindView(course:CourseModel){
            tvCourse2.text = course.code.toString() + " : " + course.name.toString()
            tvCredits.text = "Credits: " + course.credits.toString()
            tvPrereq.text =  course.prereq.toString()
            tvDescription.text = course.description.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  CourseViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.activity_course_detail,parent,false))

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.bindView(course)
        holder.itemView.setOnClickListener{ onClickCourse?.invoke(course)}

    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}