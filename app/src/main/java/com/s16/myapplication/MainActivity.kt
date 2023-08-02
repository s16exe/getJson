package com.s16.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.s16.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.button2.setOnClickListener {
            /*val enteredText = binding.textView.text.toString()

            val furl = "https://vm-g2ap.onrender.com/students/$enteredText"*/
            fetchDataFromUrl()
        }
    }

    private fun fetchDataFromUrl() {
        GlobalScope.launch(Dispatchers.IO) {
            try {

                val response = withContext(Dispatchers.IO) {
                    RetrofitInstance.api.getDataFromUrl()

                }
                if(response.isSuccessful) {
                    for(comments in response.body()!!) {
                        withContext(Dispatchers.Main) {

                            binding.textView2.text = comments.name


                        }
                    }
                }


                // Update the TextView with the important data

                // Add other relevant fields to the TextView as needed
            } catch (e: Exception) {
                // Handle exceptions here

            }
        }
    }
}