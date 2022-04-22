package com.itt420assignment.uccitapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1 ){

    companion object {
        val DATABASE_NAME = "UCC Courses"
        val TABLE_NAME = "course_listing"
        val ID = "ID"
        val CODE = "CODE"
        val NAME = "NAME"
        val CREDITS = "CREDITS"
        val PREREQUISITES = "PREREQUISITES"
        val DESCRIPTION = "DESCRIPTION"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT,CODE TEXT,NAME TEXT, CREDITS INTEGER, PREREQUISITES TEXT, DESCRIPTION TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

//Course information is inserted into the table
    fun courseData () {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CODE, "ITT101")
        contentValues.put(NAME, "Computer Information Systems")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: None")
        contentValues.put(DESCRIPTION,"This introductory course provides the necessary background for " +
        "understanding the role of information systems in organizations and for using computer tools " +
        "and technology in solving business problems.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT201")
        contentValues.put(NAME, "Data Communication & Network I")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Computer Information Systems")
        contentValues.put(DESCRIPTION,"This introductory course in Data Communications and Networks " +
        "is designed to give students an understanding of networks and how they can be used in " +
        "organizations to increase efficiency. It will also introduce IP addressing and subnets and " +
        "briefly look at security issues in networking.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT403")
        contentValues.put(NAME, "Data Communication & Network II")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Data Communication & Network I")
        contentValues.put(DESCRIPTION,"This course is aimed at providing the student with both the " +
        "advanced theoretical and practical knowledge of the standards and techniques in " +
        "Internetworking, Network security and introduction to Wireless Communications with particular " +
        "reference to cellular networks.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT203")
        contentValues.put(NAME, "Data Structures & File Management I")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Object Oriented Programming using C++")
        contentValues.put(DESCRIPTION,"This is an introductory course in data structures and file " +
        "management. It will introduce the concepts of data structures and file management so that " +
        "students become more familiar with how data is organized and manipulated.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT104")
        contentValues.put(NAME, "Database Management Systems I")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Programming Techniques")
        contentValues.put(DESCRIPTION,"This introductory course covers the concepts related to the " +
        "design and implementation of Database Management Systems.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT304")
        contentValues.put(NAME, "Database Management Systems II")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Database Management Systems I")
        contentValues.put(DESCRIPTION,"This course is aimed at providing upper level undergraduate " +
        "students with intermediate to advanced concepts in data modelling design and database " +
        "administration.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT208")
        contentValues.put(NAME, "Internet Authoring I")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Programming Techniques")
        contentValues.put(DESCRIPTION,"This introductory course in Internet Authoring will introduce " +
        "students to the tools needed to develop and publish Web Sites.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT200")
        contentValues.put(NAME, "Object Oriented Programming Using C++")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Programming Techniques")
        contentValues.put(DESCRIPTION,"This course aims to broaden the student’s knowledge of concepts " +
        "and features of an object-oriented programming language. Students will be required to use " +
        "these concepts to design solutions for real world problems.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT303")
        contentValues.put(NAME, "Programming Design Using Java")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Object Oriented Programming Using C++")
        contentValues.put(DESCRIPTION,"This introductory course in Java programming exposes the " +
        "students to the fundamental concepts of using Java to develop clearly written and well-structured " +
        "object oriented programmes that address real world problems.")
        db.insert(TABLE_NAME, null, contentValues)

        contentValues.put(CODE, "ITT103")
        contentValues.put(NAME, "Programming Techniques")
        contentValues.put(CREDITS, "Credits: 3")
        contentValues.put(PREREQUISITES,"Prerequisite: Computer Information Systems")
        contentValues.put(DESCRIPTION,"This course will introduce students to programming concepts. " +
        "Students will learn proper programming design techniques and principles.")
        db.insert(TABLE_NAME, null, contentValues)
    }

//This function will list all users
    fun listOfCourses(): ArrayList<CourseInfo>  {
        val db = this.writableDatabase
        val res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
        val courseList = ArrayList<CourseInfo>()
        while (res.moveToNext()) {
            var courseInfo = CourseInfo()
            courseInfo.id = Integer.valueOf(res.getString(0))
            courseInfo.code = res.getString(1)
            courseInfo.name = res.getString(2)
            courseInfo.credits = res.getString(3)
            courseInfo.prerequisites = res.getString(4)
            courseInfo.description = res.getString(5)
            courseList.add(courseInfo)
        }
        return courseList
    }

//This function will get all course list
    @SuppressLint("Range")
    fun getAllCourseData(): ArrayList<CourseInfo> {
        val courseInfoList: ArrayList<CourseInfo> = arrayListOf<CourseInfo>()
        val cursor: Cursor = getReadableDatabase().query(TABLE_NAME, arrayOf(ID, CODE, NAME, CREDITS, PREREQUISITES, DESCRIPTION), null, null, null, null, null)
        cursor.use { cursor ->
            if (cursor.getCount() != 0) {
                cursor.moveToFirst()
                if (cursor.getCount() > 0) {
                    do {
                        val id : Int = cursor.getInt(cursor.getColumnIndex(ID))
                        val code: String = cursor.getString(cursor.getColumnIndex(CODE))
                        val name: String = cursor.getString(cursor.getColumnIndex(NAME))
                        val credits: String = cursor.getString(cursor.getColumnIndex(CREDITS))
                        val prerequisites: String =  cursor.getString(cursor.getColumnIndex(
                            PREREQUISITES))
                        val description: String = cursor.getString(cursor.getColumnIndex(DESCRIPTION))
                        var courseInfo = CourseInfo()
                        courseInfo.id = id
                        courseInfo.code = code
                        courseInfo.name = name
                        courseInfo.credits = credits
                        courseInfo.prerequisites = prerequisites
                        courseInfo.description = description
                        courseInfoList.add(courseInfo)
                    } while ((cursor.moveToNext()))
                }
            }
        }

        return courseInfoList
    }
}