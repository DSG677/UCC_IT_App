package com.itt420assignment.uccitapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CourseListAdapter(context: Context, arrayOfData: ArrayList<CourseInfo>)  : BaseAdapter() {
    var arrayOfData : ArrayList<CourseInfo>
    private val mInflator: LayoutInflater

    init {
        this.arrayOfData = arrayOfData
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getItem(position: Int): Any {
        return arrayOfData[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayOfData.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.course_row, parent, false)
            vh = ListRowHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ListRowHolder
        }
        vh.tVCourseCode.text = arrayOfData[position].code
        vh.tVCourseName.text = ""+arrayOfData[position].name
        vh.tVCourseCredits.text = ""+arrayOfData[position].credits
        vh.tVCoursePre.text = ""+arrayOfData[position].prerequisites
        vh.tVCourseDescrip.text = ""+arrayOfData[position].description
        return view
    }

    private class ListRowHolder(row: View?) {
        public val tVCourseCode: TextView
        public val tVCourseName : TextView
        public val tVCourseCredits : TextView
        public val tVCoursePre : TextView
        public val tVCourseDescrip : TextView


        init {
            this.tVCourseCode = row?.findViewById(R.id.tVCourseCode) as TextView
            this.tVCourseName = row?.findViewById(R.id.tVCourseName) as TextView
            this.tVCourseCredits = row?.findViewById(R.id.tVCourseCredits) as TextView
            this.tVCoursePre = row?.findViewById(R.id.tVCouresPre) as TextView
            this.tVCourseDescrip = row?.findViewById(R.id.tVCourseDescrip) as TextView
        }
    }
}