package com.hanavial.exam_mobile_hanavi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hanavial.exam_mobile_hanavi.R
import com.hanavial.exam_mobile_hanavi.model.Gempa

class LatestAdapter(val dataLatest: Gempa?){
    fun getView(position: Int, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_latest,parent,false)

        val placeLatest = view.findViewById<TextView>(R.id.latest_place)
        val depthLatest = view.findViewById<TextView>(R.id.latest_depth)
        val timeLatest = view.findViewById<TextView>(R.id.latest_time)
        val coordinateLatest = view.findViewById<TextView>(R.id.latest_coordinate)
        val potencyLatest = view.findViewById<TextView>(R.id.latest_potency)
        val dateLatest = view.findViewById<TextView>(R.id.latest_date)
        val longitudeLatest = view.findViewById<TextView>(R.id.latest_longitude)
        val latitudeLatest = view.findViewById<TextView>(R.id.latest_latitude)
        val magnitudeLatest = view.findViewById<TextView>(R.id.latest_magnitude)
        val feelLatest = view.findViewById<TextView>(R.id.latest_shake)

        placeLatest.text = dataLatest?.wilayah
        depthLatest.text = dataLatest?.kedalaman
        timeLatest.text = dataLatest?.jam
        coordinateLatest.text = dataLatest?.coordinates
        potencyLatest.text = dataLatest?.potensi
        dateLatest.text = dataLatest?.tanggal
        longitudeLatest.text = dataLatest?.bujur
        latitudeLatest.text = dataLatest?.lintang
        magnitudeLatest.text = dataLatest?.magnitude
        feelLatest.text = dataLatest?.dirasakan

        return view
    }

}