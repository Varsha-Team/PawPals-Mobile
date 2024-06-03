package com.varsha.pawpals.ui.presentation.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.R
import com.varsha.pawpals.navigation.Screen
import kotlinx.coroutines.delay

// Background Color
val backgroundColor = Brush.radialGradient(
    colors = listOf(Color(0xFFFFFFFF), Color(0xFFCE5628)),
    center = Offset(540f, 1170f),
    radius = 3000f
)

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val scale = remember { Animatable(1f) }

    LaunchedEffect(
        key1 = true,
        block = {
            scale.animateTo(
                targetValue = 0.8f,
                animationSpec = tween(
                    durationMillis = 1000
                )
            )
            scale.animateTo(
                targetValue = 1.1f,
                animationSpec = tween(
                    durationMillis = 1000
                )
            )
            delay(1000L)
            navController.navigate(Screen.Onboarding.route) {
                popUpTo(Screen.Splash.route) {
                    inclusive = true
                }
            }
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)  // Apply static background here
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = modifier
                    .padding(16.dp)
                    .scale(scale.value),
                color = Color.Transparent // Ensure Surface has transparent background
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_pawpals),
                    contentDescription = "Icon APP",
                    modifier = Modifier.size(300.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}
