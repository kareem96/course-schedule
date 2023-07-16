package com.dicoding.courseschedule.paging

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.courseschedule.R
import com.dicoding.courseschedule.data.Course
import com.dicoding.courseschedule.databinding.ItemCourseBinding
import com.dicoding.courseschedule.util.DayName.Companion.getByNumber

class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var course: Course
    private val timeString = itemView.context.resources.getString(R.string.time_format)

    //TODO 7 : Complete ViewHolder to show item

    private val time = view.findViewById<TextView>(R.id.tv_time)
    private val lecturerCourse = view.findViewById<TextView>(R.id.tv_lecturer)
    private val titleCourse = view.findViewById<TextView>(R.id.tv_course)

    fun bind(course: Course, clickListener: (Course) -> Unit) {
        this.course = course

        course.apply {
            val dayName = getByNumber(day)
            val timeFormat = String.format(timeString, dayName, startTime, endTime)
            time.text = timeFormat
            lecturerCourse.text = lecturer
            titleCourse.text = courseName
        }

        itemView.setOnClickListener {
            clickListener(course)
        }
    }

    fun clear() {
        time.text = ""
        lecturerCourse.text = ""
        titleCourse.text = ""
    }

    fun getCourse(): Course = course
}