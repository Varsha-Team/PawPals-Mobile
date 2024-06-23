package com.varsha.pawpals

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.google.firebase.FirebaseApp
import com.varsha.pawpals.ui.presentation.PawPalsApp
import com.varsha.pawpals.ui.theme.PawPalsTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawPalsTheme {
                FirebaseApp.initializeApp(this)
                PawPalsApp()
            }
        }
    }
}
