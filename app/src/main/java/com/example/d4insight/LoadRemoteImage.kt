package com.example.d4insight

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation

@Composable
fun LoadRemoteImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    circular: Boolean = false
) {
    val painter: Painter = rememberImagePainter(
        data = url,
        builder = {
            crossfade(true)
            if (circular) {
                transformations(CircleCropTransformation())
            }
        }
    )

    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.None,
        // Add error and loading placeholders if needed
    )
}
