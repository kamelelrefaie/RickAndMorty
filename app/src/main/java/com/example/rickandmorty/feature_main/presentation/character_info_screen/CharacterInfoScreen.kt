package com.example.rickandmorty.feature_main.presentation.character_info_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontStyle.Companion.Normal
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.rickandmorty.feature_main.presentation.character_info_screen.components.ImageCall

@Composable
fun CharacterInfoScreen(viewModel: CharacterInfoViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 35, green = 47, blue = 52))
    ) {
        state.characterInfo?.let { charInfo ->
            ImageCall(imageUrl = state.characterInfo.image)

            Text(
                text = charInfo.name,
                fontStyle = Normal,
                textAlign = TextAlign.Start,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                rowData(dataOne = charInfo.gender)
                rowData(dataOne = charInfo.status)
            }

        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(CenterHorizontally)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
        }
    }
}

@Composable
fun rowData(dataOne: String) {
    Text(
        text = dataOne,
        color = if (dataOne == "Alive" || dataOne == "Male") Color.Green else Color.Red,
        fontStyle = Italic,
        textAlign = TextAlign.End,
        modifier = Modifier.padding(16.dp)
    )
}