package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.login.R

class ThirdFragment : Fragment() {

    private lateinit var toastButton: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        // Get the ViewModel scoped to the activity
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        toastButton = view.findViewById(R.id.toastButton)

        // Set up the Toast Button click listener
        toastButton.setOnClickListener {
            Toast.makeText(requireContext(), "Incremented ${sharedViewModel.count} times", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
