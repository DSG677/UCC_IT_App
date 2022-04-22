package com.itt420assignment.uccitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.itt420assignment.uccitapp.databinding.ActivityCourseTimetableBinding

class CourseTimetable : AppCompatActivity() {
    //View binding implemented in CourseTimetable class to easily find and interact with views
    lateinit var binding: ActivityCourseTimetableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseTimetableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieves Timetable from array in in strings.xml
        val courseTimetable: Array<String> = resources.getStringArray(R.array.CourseTimetable)

        //Creates adapter
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courseTimetable)

        //ListView populated with faculty
        val listView: ListView = binding.lVTimetable
        listView.adapter = adapter
    }
}