package com.varsha.pawpals.ui.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.varsha.pawpals.R
import com.varsha.pawpals.navigation.Screen

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .size(500.dp)
                .border(1.dp, Color.Transparent, RectangleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding),
                contentDescription = "Image Onboarding Screen",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Joyful For Your Pet",
                style = TextStyle(
                    fontSize = 32.sp,
                    lineHeight = 41.6.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF1F2223),

                    )
            )

            Text(
                text = "Trust me there’s way to make your pet love \n you more and more everyday",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF8E9090),
                    textAlign = TextAlign.Center,
                )
            )
        }
        
        Button(
            onClick = {
                navController.navigate(Screen.Login.route)
                      },
            colors = ButtonDefaults.buttonColors(Color(0xFFED6A09)),
            elevation = ButtonDefaults.elevatedButtonElevation(4.dp),
            modifier = Modifier
                .width(125.dp)
                .height(44.dp)
        ) {
            Text(
                text = "Get Started",
                fontWeight = FontWeight.Black
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(navController = rememberNavController())
}