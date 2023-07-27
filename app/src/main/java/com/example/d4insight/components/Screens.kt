package com.example.d4insight.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.d4insight.viewmodel.MainViewModel


@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val screenItems by viewModel.screenTotaItems.collectAsState()
    DynamicBoxView(screenItems.get(1).home)

}

@Composable
fun MyOrderScreen(viewModel: MainViewModel) {
    val screenItems by viewModel.screenTotaItems.collectAsState()
    DynamicBoxView(screenItems.get(2).myorder)
}


@Composable
fun ProfileScreen(viewModel: MainViewModel) {
    val screenItems by viewModel.screenTotaItems.collectAsState()
    DynamicBoxView(screenItems.get(3).profile)
}