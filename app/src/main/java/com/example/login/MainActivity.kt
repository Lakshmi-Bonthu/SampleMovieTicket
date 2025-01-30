package com.example.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup TabLayout and ViewPager2
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // List of fragments to be used in the ViewPager
        val fragments = listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        // Create an adapter for the ViewPager2
        val adapter = ViewPagerAdapter(this, fragments)
        viewPager.adapter = adapter

        // Link the TabLayout with the ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Fragment 1"
                1 -> tab.text = "Fragment 2"
                2 -> tab.text = "Fragment 3"
            }
        }.attach()
    }
}
