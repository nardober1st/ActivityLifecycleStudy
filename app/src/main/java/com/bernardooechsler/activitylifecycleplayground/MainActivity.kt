package com.bernardooechsler.activitylifecycleplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AlertDialog
import com.bernardooechsler.activitylifecycleplayground.databinding.ActivityMainBinding
import java.io.File
import java.util.Timer
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    private var isFirstLoad = true
    //    private var numberOfLoads = 0
    // Making variable seconds that we can increment
    //    var seconds2 = 0
    //    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonExit.setOnClickListener { showDialog() }
        binding.buttonSave.setOnClickListener { saveMessage() }

        onBackPressedDispatcher.addCallback { showDialog() }

        binding.textViewSavedMessage.text = savedInstanceState?.getString("savedMessage")

        // Here the timer will keeping going forever
//        var seconds = 0
//        fixedRateTimer(period = 1000L) {
//            runOnUiThread {
//                seconds++
//                binding.textViewTimer.text =
//                    "You have been staring at this screen for $seconds seconds"
//            }
//        }
//        binding.textViewRefreshStatus.text = "Welcome to the app! Here is your feed..."
//        Log.d("BernardoOechsler1", "IM in onCreate()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedTextViewMessage = binding.textViewSavedMessage.text.toString()
        outState.putString("savedMessage", savedTextViewMessage)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun saveMessage() {
        val userMessage = binding.editTextMessage.text
        // Making a  new file called message.txt and adding the userMessage to it
        File(filesDir, "user message.txt").writeText(userMessage.toString())
        binding.textViewSavedMessage.text =
            "Your message has been saved!\n\nMessage Preview:\n\n$userMessage"
        binding.editTextMessage.setText("")
    }

    // Rarely used in a real programming job
//    override fun onDestroy() {
//        super.onDestroy()
//        val userMessage = binding.editTextMessage.text
//        // Making a  new file called message.txt and adding the userMessage to it
//        File(filesDir, "user message.txt").writeText(userMessage.toString())
//    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Warning!")
//            .setMessage("You are about to leave the app. Are you sure you want to exit?")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("Yes") { _, _ ->
                finish()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .setNeutralButton("More info") { dialog, _ ->
                Toast.makeText(
                    this,
                    "This is where the more info screen could be!",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }
            .show()
    }


    // Starting the timer again when the user reopen the app
//    override fun onResume() {
//        super.onResume()
//        timer = fixedRateTimer(period = 1000L) {
//            runOnUiThread {
//                seconds2++
//                binding.textViewTimer2.text =
//                    "You have been staring at this screen for $seconds2 seconds"
//            }
//        }
//    }
//
//    override fun onPause() {
//        super.onPause()
//        // When the user backgrounds the app, the timer will stop, because we are using the '.cancel()' method, but when we
//        // comeback to the app, the timer will be stopped so we gotta call it again on onResume()
//        timer.cancel()
//    }

//    override fun onRestart() {
//        super.onRestart()
//        binding.textViewRefreshStatus.text = "your feed has been updated"
//    }

//    override fun onResume() {
//        super.onResume()
//        numberOfLoads++
//        binding.textViewRefreshStatus.text =
//            "Welcome to the app! Here is your feed...! We have loaded ur content $numberOfLoads time(s)"
//    }

//    override fun onResume() {
//        super.onResume()
//        if (isFirstLoad) {
//            binding.textViewRefreshStatus.text = "Welcome to the app! Here is your feed..."
//            isFirstLoad = false
//        } else {
//            binding.textViewRefreshStatus.text = "your feed has been updated"
//        }
//    }

//    // When our Activity becomes VISIBLE
//    override fun onStart() {
//        super.onStart()
//        Log.d("BernardoOechsler1", "IM in onStart()")
//    }
//
//    // When our Activity is in the FOREGROUND
//    override fun onResume() {
//        super.onResume()
//        Log.d("BernardoOechsler1", "IM in onResume()")
//    }
//
//    // When our Activity IS STILL VISIBLE, but it is in the BACKGROUND
//    // (e.g. An Activity "Dialog" is on top, but we can still see our Activity
//    override fun onPause() {
//        super.onPause()
//        Log.d("BernardoOechsler1", "IM in onPause()")
//    }
//
//    // When our Activity is no longer VISIBLE (but still running)
//    override fun onStop() {
//        super.onStop()
//        Log.d("BernardoOechsler1", "IM in onStop()")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("BernardoOechsler1", "IM onDestroy()")
//    }
}