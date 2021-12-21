package com.example.rickandmorty.feature_main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.rickandmorty.feature_main.domain.model.CharacterInfo
import com.example.rickandmorty.feature_main.presentation.character_list_screen.CharacterListViewModel
import com.example.rickandmorty.feature_main.presentation.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val viewModel: CharacterListViewModel = hiltViewModel()

                    val userListItem: LazyPagingItems<CharacterInfo> =
                        viewModel.characterList.collectAsLazyPagingItems()
                    LazyColumn {
                          items(userListItem){
                              it?.let {
                                      Text(text ="->${it.id}      "+ it.name + it.gender)
                              }
                          }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickAndMortyTheme {
        Greeting("Android")
    }
}