package com.hanavial.exam_mobile_hanavi.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hanavial.exam_mobile_hanavi.model.GempaItem
import com.hanavial.exam_mobile_hanavi.adapter.MagnitudeAdapter
import com.hanavial.exam_mobile_hanavi.R
import com.hanavial.exam_mobile_hanavi.model.ResponseMagnitude
import com.hanavial.exam_mobile_hanavi.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MagnitudeFragment : Fragment() {

    private lateinit var myContext: Context
    private var itemList = arrayListOf<GempaItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myContext = container?.context!!
        return inflater.inflate(R.layout.fragment_magnitude, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val magnitudeRecycler = view.findViewById<RecyclerView>(R.id.magnitude_recyclerview)
        ApiConfig.getService().getMagnitude().enqueue(object : Callback<ResponseMagnitude> {
            override fun onResponse(call: Call<ResponseMagnitude>, response: Response<ResponseMagnitude>) {
                if (response.isSuccessful) {
                    val responseMg = response.body()
                    val adapter = MagnitudeAdapter(itemList)
                    magnitudeRecycler.adapter = adapter
                    magnitudeRecycler.layoutManager = LinearLayoutManager(myContext, RecyclerView.VERTICAL , false)
                    itemList.clear()
                    for (gempa in responseMg?.infogempa?.gempa!!) {
                        gempa?.let { itemList.add(it) }
                    }
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<ResponseMagnitude>, t: Throwable) {

            }
        })
    }
}