package com.example.rickandmorty.feature_main.presentation.character_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.rickandmorty.feature_main.presentation.ui.theme.RickAndMortyTheme


@ExperimentalMaterialApi
@Composable
fun SingleCharacterItem(
    imageUrl: String,
    name: String,
    id :Int,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(0.5f).padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp,
        onClick = {onItemClicked(id)}
    ) {
        Box(Modifier.height(200.dp)) {
            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = "Image_In_List",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )

           Box(
               Modifier
                   .fillMaxSize()
                   .padding(12.dp), contentAlignment = Alignment.BottomStart) {
               Text(text = name, style = TextStyle(color = Color.White), fontSize = 12.sp)
           }
        }

    }

}


