package com.itt420assignment.uccitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.itt420assignment.uccitapp.databinding.ActivityCourseListingBinding

class CourseListing : AppCompatActivity() {
    //View binding implemented in CourseListing class to easily find and interact with views
    private var helper = DatabaseHandler(this)

    lateinit var binding: ActivityCourseListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var listData: ArrayList<CourseInfo> = helper.listOfCourses()

        var listView: ListView = binding.lVCourseList
        var listAdapter = CourseListAdapter(this, listData)
        listView.adapter = listAdapter
    }
}