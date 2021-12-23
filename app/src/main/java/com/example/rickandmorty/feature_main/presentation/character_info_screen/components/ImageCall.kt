package com.example.rickandmorty.feature_main.presentation.character_info_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ImageCall(
    imageUrl: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Image(
            painter = rememberImagePainter(imageUrl) {
               crossfade(true)
                crossfade(250)
            },

            contentDescription = "image_info",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }

}