package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.login.R

class SecondFragment : Fragment() {

    private lateinit var counterText: TextView
    private lateinit var incrementButton: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        // Get the ViewModel scoped to the activity
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        counterText = view.findViewById(R.id.counterText)
        incrementButton = view.findViewById(R.id.incrementButton)

        // Display initial count
        counterText.text = sharedViewModel.count.toString()

        // Increment the counter on button click
        incrementButton.setOnClickListener {
            sharedViewModel.count++  // Update count in the ViewModel
            counterText.text = sharedViewModel.count.toString()  // Update UI
        }

        return view
    }
}
