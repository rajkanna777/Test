package com.example.d4insight.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.d4insight.LoadRemoteImage
import com.example.d4insight.model.BottomNavItem

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    currentScreenId: String,
    onScreenSelected: (String) -> Unit
) {
    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    LoadRemoteImage(
                        url = item.iconUrl,
                        contentDescription = item.label,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(4.dp),
                        circular = true
                    )
                },
                label = { Text(text = item.label) },
                selected = currentScreenId == item.screenId,
                onClick = { onScreenSelected(item.screenId) }
            )
        }
    }
}
