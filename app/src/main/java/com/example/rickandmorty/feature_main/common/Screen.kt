package com.example.rickandmorty.feature_main.common


sealed class Screen(val route: String) {
    object SplashScreen: Screen("rick_splash_screen")
    object CharacterListScreen : Screen("character_list_screen")
    object CharacterInfoScreen : Screen("character_info_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}