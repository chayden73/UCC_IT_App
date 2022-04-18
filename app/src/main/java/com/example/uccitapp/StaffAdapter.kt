package com.example.uccitapp

import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StaffAdapter():RecyclerView.Adapter<StaffAdapter.StaffViewHolder>() {
    private var staffList:ArrayList<StaffModel> = ArrayList()
    private var onClickStaff:((StaffModel)->Unit)? = null
    private var onClickEmail:((StaffModel)->Unit)? = null
    private var onClickPhone:((StaffModel)->Unit)? = null

    fun addStaff(staffList:ArrayList<StaffModel>){
        this.staffList = staffList
        notifyDataSetChanged()
    }

    fun setOnClickStaff(callback: (StaffModel) -> Unit){
        this.onClickStaff = callback
    }

    fun setOnClickEmail(callback: (StaffModel)->Unit){
        this.onClickEmail = callback
    }

    fun setOnClickPhone(callback: (StaffModel)->Unit){
        this.onClickPhone = callback
    }

    class StaffViewHolder(var view: View):RecyclerView.ViewHolder(view){
        private var tvName = view.findViewById<TextView>(R.id.tvName)
        private  var tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        private var tvProgramme = view.findViewById<TextView>(R.id.tvProg)
        var tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        var tvPhone = view.findViewById<TextView>(R.id.tvPhone)
        private var ivPhoto: ImageView =  view.findViewById<ImageView>(R.id.ivPhoto)

        fun bindView(staff:StaffModel){
            var id = view.resources.getIdentifier(staff.photo_name.toString(),"drawable",view.context.packageName)
            ivPhoto.setImageResource(id)
            tvName.text = staff.name.toString()
            tvTitle.text = staff.title.toString()
            tvProgramme.text = staff.programme.toString()
            tvEmail.text = staff.email.toString()
            tvPhone.text = staff.phone.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StaffViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.card_item_staff,parent,false))

    override fun onBindViewHolder(holder: StaffAdapter.StaffViewHolder, position: Int) {
        val staff = staffList[position]
        holder.bindView(staff)
        holder.itemView.setOnClickListener { onClickStaff?.invoke(staff) }
        holder.tvEmail.setOnClickListener { onClickEmail?.invoke(staff) }
        holder.tvPhone.setOnClickListener { onClickPhone?.invoke(staff) }
    }

    override fun getItemCount(): Int {
        return staffList.size
    }
}