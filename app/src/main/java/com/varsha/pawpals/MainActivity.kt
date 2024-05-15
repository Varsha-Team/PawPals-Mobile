package com.varsha.pawpals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.varsha.pawpals.ui.presentation.PawPalsApp
import com.varsha.pawpals.ui.theme.PawPalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawPalsTheme {
                PawPalsApp()
            }
        }
    }
}
