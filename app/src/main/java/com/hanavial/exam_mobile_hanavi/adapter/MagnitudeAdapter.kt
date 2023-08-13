package com.hanavial.exam_mobile_hanavi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hanavial.exam_mobile_hanavi.model.GempaItem
import com.hanavial.exam_mobile_hanavi.R

class MagnitudeAdapter(val dataMagnitude: List<GempaItem?>?) : RecyclerView.Adapter<MagnitudeAdapter.viewHolder>(){
    class viewHolder (view: View) :RecyclerView.ViewHolder(view){
        val placeMagnitude = view.findViewById<TextView>(R.id.place)
        val depthMagnitude = view.findViewById<TextView>(R.id.depth)
        val timeMagnitude = view.findViewById<TextView>(R.id.time)
        val coordinateMagnitude = view.findViewById<TextView>(R.id.coordinate)
        val potencyMagnitude = view.findViewById<TextView>(R.id.potency)
        val dateMagnitude = view.findViewById<TextView>(R.id.date)
        val longitudeMagnitude = view.findViewById<TextView>(R.id.longitude)
        val latitudeMagnitude = view.findViewById<TextView>(R.id.latitude)
        val itemMagnitude = view.findViewById<TextView>(R.id.item_magnitude)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataMagnitude != null){
            return dataMagnitude.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.placeMagnitude.text = dataMagnitude?.get(position)?.wilayah
        holder.depthMagnitude.text = dataMagnitude?.get(position)?.kedalaman
        holder.timeMagnitude.text = dataMagnitude?.get(position)?.jam
        holder.coordinateMagnitude.text = dataMagnitude?.get(position)?.coordinates
        holder.potencyMagnitude.text = dataMagnitude?.get(position)?.potensi
        holder.dateMagnitude.text = dataMagnitude?.get(position)?.tanggal
        holder.longitudeMagnitude.text = dataMagnitude?.get(position)?.bujur
        holder.latitudeMagnitude.text = dataMagnitude?.get(position)?.lintang
        holder.itemMagnitude.text = dataMagnitude?.get(position)?.magnitude
    }
}