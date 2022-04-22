package com.itt420assignment.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.itt420assignment.uccitapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    //View binding implemented in MainActivity class to easily find and interact with views
    private var helper = DatabaseHandler(this)

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//"Listens" for when the Staff Directory button is pressed and sends user to the Staff Directory activity
        binding.buttonDirectory.setOnClickListener {
            val myIntent = Intent(this, StaffDirectory::class.java)
            startActivity(myIntent)
        }

//"Listens" for when the Course button is pressed and sends user to the Staff Directory activity
        binding.buttonCourses.setOnClickListener {
            helper.courseData()
            val myIntent = Intent(this, CourseListing::class.java)
            startActivity(myIntent)
        }

//"Listens" for when the Timetable button is pressed and sends user to the CourseTimetable activity
        binding.buttonTimetable.setOnClickListener {
            val myIntent = Intent(this, CourseTimetable::class.java)
            startActivity(myIntent)
        }

//"Listens" for when the Admission button is pressed and sends user to the Admissions activity
       binding.buttonAdmission.setOnClickListener {
           val myIntent = Intent(this, Admissions::class.java)
           startActivity(myIntent)
        }

    val emailHOD = "ithod@ucc.edu.jm"

//Open mail app to send an email to the HOD when FAB button is pressed
        binding.fabEmail.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", emailHOD, null))
            startActivity(myIntent)
        }

//UCC social media links
    val facebookPage = "https://www.facebook.com/uccjamaica"
    val twitterPage = "https://twitter.com/uccjamaica"
    val instagramPage = "https://www.instagram.com/uccjamaica/"

//User will be redirected to UCC's Facebook page
    binding.iBFacebook.setOnClickListener {
         val myIntent = Intent(Intent.ACTION_VIEW)
         myIntent.data = Uri.parse(facebookPage)
         startActivity(myIntent)
        }

//User will be redirected to UCC's Twitter page
    binding.iBTwitter.setOnClickListener {
         val myIntent = Intent(Intent.ACTION_VIEW)
         myIntent.data = Uri.parse(twitterPage)
         startActivity(myIntent)
        }

//User will be redirected to UCC's Instagram page
    binding.iBInstagram.setOnClickListener {
         val myIntent = Intent(Intent.ACTION_VIEW)
         myIntent.data = Uri.parse(instagramPage)
         startActivity(myIntent)
        }

    }

}


/*
References
UCC Home | University of the Commonwealth Caribbean. (n.d.). UCC. https://ucc.edu.jm/
How to set background color for android layout pragmatically using java and through xml | Code2care. (2020, July 26). Code2care. https://code2care.org/pages/set-background-color-android-layout-pragmatically-using-java-and-through-xml
Icons8. (n.d.). Social media icons in Stickers style for graphic & UI design. https://icons8.com/icon/set/social-media/stickers
View Binding. (n.d.). Android Developers. https://developer.android.com/topic/libraries/view-binding
Sending the user to another app |. (n.d.). Android Developers. https://developer.android.com/training/basics/intents/sending#kotlin
Information Technology | University of the Commonwealth Caribbean. (n.d.). UCC. https://ucc.edu.jm/programmes/tm/bsc-in-information-technology
How to make a new line or tab in XML (eclipse/android)? (2012, December 30). Stack Overflow. https://stackoverflow.com/questions/14091760/how-to-make-a-new-line-or-tab-in-string-xml-eclipse-android
sicarii13. (n.d.). GitHub - sicarii13/SQLite_Demo. GitHub. https://github.com/sicarii13/SQLite_Demo
sicarii13. (n.d.). GitHub - sicarii13/myUCC: Activity Demo App. GitHub. https://github.com/sicarii13/myUCC
*/