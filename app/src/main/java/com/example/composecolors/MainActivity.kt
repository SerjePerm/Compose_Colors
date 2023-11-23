package com.example.composecolors

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.composecolors.ui.navigation.NavGraph
import com.example.composecolors.ui.navigation.ShowBottomNavigation
import com.example.composecolors.ui.theme.ComposeColorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowMainScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowMainScreen() {
    ComposeColorsTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = { ShowBottomNavigation(navController = navController) }
        ) {
            NavGraph(navHostController = navController)
        }

    }
}