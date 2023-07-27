package com.example.d4insight.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.d4insight.LoadRemoteImage
import com.example.d4insight.model.ScreenItem

@Composable
fun DynamicBoxView(item: ScreenItem) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
                contentAlignment = Alignment.Center// Set the background color of the Box
    ) {
        when (item.type) {
            "box" -> {
                // Handle child items of type "box"
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    item.children.forEach { child ->
                        when (child.type) {
                            "image" -> {
                                LoadRemoteImage(
                                    url = child.url ?: "",
                                    contentDescription = child.text ?: "",
                                    modifier = Modifier
                                        .size(150.dp)
                                        .padding(16.dp)
                                )
                            }
                            "text" -> {
                                Text(
                                    text = child.text ?: "",
                                    modifier = Modifier.padding(16.dp),
                                    textAlign = TextAlign.Center


                                )
                            }
                            // Add more cases for other types if needed
                        }
                    }
                }
            }
            // Add more cases for other types if needed
        }
    }
}
