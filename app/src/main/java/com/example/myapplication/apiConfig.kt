package com.example.myapplication

import com.google.ai.client.generativeai.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel

object apiConfig {
    val apiKey = "AIzaSyDcsDIm_0DFu3pOg76tUyTYBAhxF_efb64"
    val generativeModel = GenerativeModel(

        modelName = "gemini-1.5-flash",
        // Access your API key as a Build Configuration variable (see "Set up your API key" above)
        apiKey = apiKey
    )
}