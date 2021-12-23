package com.example.rickandmorty.feature_main.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmorty.feature_main.common.Constants
import com.example.rickandmorty.feature_main.common.Screen
import com.example.rickandmorty.feature_main.presentation.character_info_screen.CharacterInfoScreen
import com.example.rickandmorty.feature_main.presentation.character_info_screen.CharacterInfoViewModel
import com.example.rickandmorty.feature_main.presentation.character_info_screen.components.ImageCall
import com.example.rickandmorty.feature_main.presentation.character_list_screen.CharacterListScreen


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {

        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.CharacterInfoScreen.route) {
            CharacterListScreen(navController)
        }
        composable(
            route = Screen.CharacterInfoScreen.route + "/{${Constants.CHARACTER_ID}}",
            arguments = listOf(navArgument(Constants.CHARACTER_ID) {
                type = NavType.IntType
            })
        ) {
           CharacterInfoScreen()
        }
    }
}