package com.itt420assignment.uccitapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.itt420assignment.uccitapp.databinding.ActivityStaffDirectoryBinding

class StaffDirectory : AppCompatActivity() {
    //View binding implemented in StaffDirectory class to easily find and interact with views
    lateinit var binding: ActivityStaffDirectoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaffDirectoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieves Directory from array in in strings.xml
        val staffDirectory: Array<String> = resources.getStringArray(R.array.StaffDirectory)

        //Creates adapter
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, staffDirectory)

        //ListView populated with faculty
        val listView: ListView = binding.lVStaffDirectory
        listView.adapter = adapter

        //Starts StaffInfo Activity when a Staff member is selected
        listView.setOnItemClickListener { parent, view, position, id ->
            val myIntent = Intent(this, StaffInfo::class.java)

            //Stores and transfers index to StaffInfo activity
            myIntent.putExtra("Index", position.toString())
            this.startActivity(myIntent)
        }
    }
}