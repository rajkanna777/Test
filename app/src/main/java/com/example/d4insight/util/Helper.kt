package com.example.d4insight.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonParseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class Helper(private val context: Context) {
    fun getJsonDataFromAssets(): String {
        return context.assets.open("assignment.json").bufferedReader().use {
            it.readText()
        }
    }
}
