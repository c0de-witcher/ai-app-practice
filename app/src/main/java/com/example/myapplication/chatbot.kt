package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.model.AdapterClass
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityChatbotBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class chatbot : AppCompatActivity() {
    val list = ArrayList<message>()
    lateinit var binding : ActivityChatbotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChatbotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.setHasFixedSize(true)


        var prompt: String = ""


        binding.send.setOnClickListener {
            prompt = binding.edittext.text.toString()
            list.add(message(prompt, true))

            binding.recycle.adapter = adapter(list)
            binding.edittext.text = null


            Log.i(TAG, prompt)
            val job = CoroutineScope(Dispatchers.Main).async {
                val response = apiConfig.generativeModel.generateContent(prompt)
                val res = response.text.toString()
                list.add(message(res, false))
                Log.i(TAG, res)
                binding.recycle.adapter = adapter(list)


            }


        }
    }
    }
