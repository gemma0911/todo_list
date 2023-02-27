package com.example.app.login.todolist

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.app.login.todolist.R.layout
import com.example.app.login.todolist.R.layout.task
import com.example.app.login.todolist.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = TextView(this)
        binding.add.setOnClickListener {
            addTask()
        }
    }

    private fun addTask() {
//        val vibration: Vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//        if (vibration.hasVibrator()) {
//            vibration.vibrate(20000); // for 500 ms
//        }
//        binding.linearLayout2.visibility = View.GONE
        val dialog = BottomSheetDialog(this,)
        val view = layoutInflater.inflate(task, null)
        dialog.setContentView(view)
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        dialog.show()
    }

    fun click(view: View) {
        val datePicker = MaterialDatePicker.Builder.datePicker().build()
        datePicker.show(supportFragmentManager, "DatePicker")
        datePicker.addOnPositiveButtonClickListener {
            val dateFormatter = SimpleDateFormat("dd-MM-yyyy")
            val date = dateFormatter.format(Date(it))
            Toast.makeText(this, "$date is selected", Toast.LENGTH_LONG).show()
        }
        // Setting up the event for when cancelled is clicked
        datePicker.addOnNegativeButtonClickListener {
            Toast.makeText(this, "${datePicker.headerText} is cancelled", Toast.LENGTH_LONG)
                .show()
        }
        // Setting up the event for when back button is pressed
        datePicker.addOnCancelListener {
            Toast.makeText(this, "Date Picker Cancelled", Toast.LENGTH_LONG).show()
        }
    }
}
