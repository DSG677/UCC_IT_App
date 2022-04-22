package com.itt420assignment.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.itt420assignment.uccitapp.databinding.ActivityStaffInfoBinding

class StaffInfo : AppCompatActivity() {
    //View binding implemented in StaffInfo class to easily find and interact with views
    lateinit var binding: ActivityStaffInfoBinding

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStaffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Gets index from StaffDirectory activity
        val index: String? = this.intent.getStringExtra("Index")

        //Creates objects for each StaffInfo view
        val name: TextView = binding.tVStaffName
        val photo: ImageView = binding.iVStaffPhoto
        val telephone: TextView = binding.tVStaffTelephone
        val email: TextView = binding.tVStaffEmail

        //Assigns value to StaffInfo views
        when (index){

            "0" -> {
                name.text = "MCBEAN, Rochelle"
                photo.setImageResource(R.drawable.rochelle_mcbean)
                telephone.text = "(876)555-8076"
                email.text = "rmcbean@faculty.ucc.edu.jm"
            }
            "1" -> {
                name.text = "OSBOURNE, Otis"
                photo.setImageResource(R.drawable.otis_osbourne)
                telephone.text = "(876)555-8176"
                email.text = "itfaculty@ucc.edu.jm"
            }
            "2" -> {
                name.text = "ROSE, Natalie"
                photo.setImageResource(R.drawable.natalie_rose_hod)
                telephone.text = "(876)555-8276"
                email.text = "ithod@ucc.edu.jm"
            }
            "3" -> {
                name.text = "Williams, Neil"
                photo.setImageResource(R.drawable.neil_williams)
                telephone.text = "(876)555-8376"
                email.text = "itlecturer@ucc.edu.jm"
            }

        }

        //Allows user to make a call when call button is pressed
        binding.fabStaffCall.setOnClickListener{
            val myIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telephone"))
            startActivity(myIntent)
           }
        //Allows user to send an email when email button is pressed
        binding.fabStaffEmail.setOnClickListener{
            val myIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email.toString(), null))
            startActivity(myIntent)
           }
    }
}