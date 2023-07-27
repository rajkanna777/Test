package com.example.d4insight.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.d4insight.model.Dashboard
import com.example.d4insight.model.DashboardData
import com.example.d4insight.model.ScreenItem
import com.example.d4insight.util.Helper
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// MainViewModel.kt
@HiltViewModel
class MainViewModel @Inject constructor(
    private val helper: Helper,
) : ViewModel() {

    private val _screenItems = MutableStateFlow<List<Dashboard>>(emptyList())
    val screenItems: StateFlow<List<Dashboard>> = _screenItems
    private val _screenTotaItems = MutableStateFlow<List<DashboardData>>(emptyList())
    val screenTotaItems: StateFlow<List<DashboardData>> = _screenTotaItems

    init {
        viewModelScope.launch {
            val jsonData = helper.getJsonDataFromAssets()
            val items = parseJsonData(jsonData)
            _screenTotaItems.value= items
            _screenItems.value = listOf(items.get(0).dashboard)
        }
    }

    fun parseJsonData(jsonData: String): List<DashboardData> {
        val listType = object : TypeToken<List<DashboardData>>() {}.type
        return Gson().fromJson(jsonData, listType)
    }



}