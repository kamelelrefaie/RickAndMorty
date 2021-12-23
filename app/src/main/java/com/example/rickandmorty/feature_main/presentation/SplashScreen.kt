package com.example.rickandmorty.feature_main.presentation

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.rickandmorty.R
import com.example.rickandmorty.feature_main.common.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            tween(durationMillis = 500, easing = {
                // 2f -> 1f
                OvershootInterpolator(2f).getInterpolation(it)

            })
        )
        delay(2000)
        navController.navigate(Screen.CharacterInfoScreen.route)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color.Green,
                        Color.White
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.rick_logo),
            contentDescription = "logo", Modifier.scale(scale.value)
        )
    }
}