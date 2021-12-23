package com.example.rickandmorty.feature_main.presentation.character_list_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickandmorty.feature_main.common.Screen
import com.example.rickandmorty.feature_main.presentation.character_list_screen.components.SingleCharacterItem
import java.time.format.TextStyle

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val charList = viewModel.characterList.collectAsLazyPagingItems()
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 35, green = 47, blue = 52))
    ) {
        items(charList.itemCount) { index ->
            charList[index]?.let {
                SingleCharacterItem(imageUrl = it.image, name = it.name, id = it.id) { id ->
                    navController.navigate(
                        Screen.CharacterInfoScreen.withArgs(
                            "${id}"
                        )
                    )
                }
            }

        }

    }

    charList.apply {
        when {
            loadState.refresh is LoadState.Loading -> {


                LoadingItem()

            }
            loadState.append is LoadState.Loading -> {

                LoadingItem()

            }
            loadState.refresh is LoadState.Error -> {
                val e = charList.loadState.refresh as LoadState.Error

                ErrorItem(
                    message = e.error.localizedMessage!!,
                )

            }
            loadState.append is LoadState.Error -> {
                val e = charList.loadState.append as LoadState.Error

                ErrorItem(
                    message = e.error.localizedMessage!!,

                    )

            }
        }
    }
}

@Composable
fun ErrorItem(message: String) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(
            text = message,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal,
            color = Color.Red,
            modifier = Modifier
                .align(CenterHorizontally)
        )
    }


}

@Composable
fun LoadingItem() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator(
            color = Color.Green, modifier = Modifier
                .align(CenterHorizontally)
                .size(200.dp)
        )
    }

}