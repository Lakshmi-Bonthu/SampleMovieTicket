package com.example.login

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return 3 // Number of fragments
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()  // Replace with your fragment class
            1 -> SecondFragment() // Replace with your fragment class
            2 -> ThirdFragment()  // Replace with your fragment class
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}
