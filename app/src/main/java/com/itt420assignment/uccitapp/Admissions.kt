package com.itt420assignment.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itt420assignment.uccitapp.databinding.ActivityAdmissionsBinding

class Admissions : AppCompatActivity() {
    //View binding implemented in Admissions class to easily find and interact with views
    lateinit var binding: ActivityAdmissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdmissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    //UCC Application Page URL
    val applicationPage = "https://ucc.edu.jm/apply/"

    //User will be led to UCC's Application Page once URL is pressed
    binding.tVApplicationURL.setOnClickListener {
        val myIntent = Intent(Intent.ACTION_VIEW)
        myIntent.data = Uri.parse(applicationPage)
        startActivity(myIntent)
    }
    }
}