package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.login.R

class FirstFragment : Fragment() {

    private lateinit var inputText: EditText
    private lateinit var resultText: TextView
    private lateinit var displayButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Use 'view.findViewById' to get views inside the fragment
        inputText = view.findViewById(R.id.inputText)
        resultText = view.findViewById(R.id.resultText)
        displayButton = view.findViewById(R.id.displayButton)

        // Button click to show input text
        displayButton.setOnClickListener {
            resultText.text = inputText.text.toString()
        }

        return view
    }
}
