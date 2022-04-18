package com.example.uccitapp

import android.content.Intent
import android.content.res.TypedArray
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Directory: AppCompatActivity() {
    lateinit var lvStaff: RecyclerView
    var adapter: StaffAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)


        val directoryNames: Array<String> = resources.getStringArray(R.array.directory_0)
        val directoryTitles: Array<String> = resources.getStringArray(R.array.directory_1)
        val directoryProgrammes: Array<String> = resources.getStringArray(R.array.directory_2)
        val directoryEmails: Array<String> = resources.getStringArray(R.array.directory_3)
        val directoryPhones: Array<String> = resources.getStringArray(R.array.directory_4)
        val directoryPhotoName: Array<String> = resources.getStringArray(R.array.directory_5)


        val staffList : ArrayList<StaffModel> = ArrayList()

        for (i in directoryNames.indices ){
            val staff = StaffModel(directoryNames[i],directoryTitles[i],directoryProgrammes[i],directoryEmails[i],directoryPhones[i],directoryPhotoName[i])
            staffList.add(staff)
        }

        lvStaff = findViewById(R.id.lvStaff)

        lvStaff.layoutManager = LinearLayoutManager(this)
        adapter = StaffAdapter()
        lvStaff.adapter = adapter
        adapter?.addStaff(staffList)

        adapter?.setOnClickEmail {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", it.email, null))
            intent.putExtra(Intent.EXTRA_EMAIL, it.email)
            startActivity(intent)
        }

        adapter?.setOnClickPhone {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ it.phone))
            startActivity(intent)
        }












    }
}