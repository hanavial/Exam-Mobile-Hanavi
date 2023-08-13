package com.hanavial.exam_mobile_hanavi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hanavial.exam_mobile_hanavi.databinding.ActivityMainBinding
import com.hanavial.exam_mobile_hanavi.fragment.LatestFragment
import com.hanavial.exam_mobile_hanavi.fragment.MagnitudeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(LatestFragment())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.latest -> replaceFragment(LatestFragment())
                R.id.magnitude -> replaceFragment(MagnitudeFragment())
                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}