package com.example.d4insight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.d4insight.components.*
import com.example.d4insight.ui.theme.D4InsightTheme
import com.example.d4insight.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D4InsightTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    AppUI(viewModel)
                }
            }
        }
    }
}


// AppUI.kt
@Composable
fun AppUI(viewModel: MainViewModel) {
    val screenItems by viewModel.screenItems.collectAsState()
    val totalsItem by viewModel.screenTotaItems.collectAsState()
    var currentScreen by remember { mutableStateOf(screenItems.first().children.first().screenId) }


    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = screenItems.first().children,
                currentScreenId = currentScreen,
                onScreenSelected = { screenId ->
                    currentScreen = screenId
                }
            )
        }
    ) { innerPadding ->
        // Show the selected screen based on the currentScreen variable
        when (currentScreen) {
            "home" -> DynamicBoxView(totalsItem.get(1).home)
            "myorder" -> DynamicBoxView(totalsItem.get(2).myorder)
            "profile" -> DynamicBoxView(totalsItem.get(3).profile)
            // Add more cases for other screenIds
        }
    }
}





