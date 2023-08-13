package com.hanavial.exam_mobile_hanavi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hanavial.exam_mobile_hanavi.R
import com.hanavial.exam_mobile_hanavi.api.ApiConfig
import com.hanavial.exam_mobile_hanavi.model.ResponseLatest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LatestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_latest, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ApiConfig.getService().getLatest().enqueue(object : Callback<ResponseLatest>{
            override fun onResponse(call: Call<ResponseLatest>, response: Response<ResponseLatest>) {
                if (response.isSuccessful){
                    val responseLt = response.body()
                    val dataLatest = responseLt?.infogempa?.gempa

                    val placeLatest = view.findViewById<TextView>(R.id.latest_place)
                    val depthLatest = view.findViewById<TextView>(R.id.latest_depth)
                    val timeLatest = view.findViewById<TextView>(R.id.latest_time)
                    val coordinateLatest = view.findViewById<TextView>(R.id.latest_coordinate)
                    val potencyLatest = view.findViewById<TextView>(R.id.latest_potency)
                    val dateLatest = view.findViewById<TextView>(R.id.latest_date)
                    val longitudeLatest = view.findViewById<TextView>(R.id.latest_longitude)
                    val latitudeLatest = view.findViewById<TextView>(R.id.latest_latitude)
                    val magnitudeLatest = view.findViewById<TextView>(R.id.latest_magnitude)
                    val shakeLatest = view.findViewById<TextView>(R.id.latest_shake)
                    val shakemapLatest = view.findViewById<ImageView>(R.id.latest_shakemap)

                    placeLatest.text = dataLatest?.wilayah
                    depthLatest.text = dataLatest?.kedalaman
                    timeLatest.text = dataLatest?.jam
                    coordinateLatest.text = dataLatest?.coordinates
                    potencyLatest.text = dataLatest?.potensi
                    dateLatest.text = dataLatest?.tanggal
                    longitudeLatest.text = dataLatest?.bujur
                    latitudeLatest.text = dataLatest?.lintang
                    magnitudeLatest.text = dataLatest?.magnitude
                    shakeLatest.text = dataLatest?.dirasakan

                    Glide.with(shakemapLatest)
                        .load("https://data.bmkg.go.id/DataMKG/TEWS/" + dataLatest?.shakemap)
                        .error(R.drawable.ic_launcher_background)
                        .into(shakemapLatest)
                }
            }
            override fun onFailure(call: Call<ResponseLatest>, t: Throwable) {

            }
        })
    }
}