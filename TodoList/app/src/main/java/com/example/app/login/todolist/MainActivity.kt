package com.example.app.login.todolist

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import com.example.app.login.todolist.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val text =  TextView(this)
        text.setText("hehe")
        binding.add.setOnClickListener {
//            binding.linearLayout2.visibility = View.GONE
            val dialog = BottomSheetDialog(this)
            val view = layoutInflater.inflate(R.layout.task,null)
            dialog.setContentView(view)
            dialog.show()
      }

        val myTextView = findViewById<TextView>(R.id.editTextTextPassword)
        myTextView.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // The soft keyboard is shown, so reduce the size of the TextView
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            } else {
                // The soft keyboard is hidden, so restore the original size of the TextView
                myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
            }
        }

    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Check if the keyboard is hidden or shown in the new configuration
        if (newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_NO) {
            // The soft keyboard is shown, so reduce the size of the TextView
            val myTextView = findViewById<TextView>(R.id.textView2)
            myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        } else {
            // The soft keyboard is hidden, so restore the original size of the TextView
            val myTextView = findViewById<TextView>(R.id.textView2)
            myTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        }
    }

}