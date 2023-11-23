package com.example.composecolors.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composecolors.R
import com.example.composecolors.screens.CompactScreen
import com.example.composecolors.screens.FullScreen
import com.example.composecolors.ui.navigation.Constants.BottomNavItems

data class BottomNavItem(val title: String, val iconId: Int, val route: String)

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem("Compact", R.drawable.compact, Routes.compact_route),
        BottomNavItem("Full", R.drawable.full, Routes.full_route),
    )
}

@Composable
fun ShowBottomNavigation(navController: NavController) {
    BottomNavigation()
    {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        BottomNavItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = { Icon(painter = painterResource(id = item.iconId), contentDescription = null) },
                label = { Text(text = item.title) }
                //selectedContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
                //unselectedContentColor = androidx.compose.material3.MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.full_route) {
        composable(Routes.compact_route) { CompactScreen() }
        composable(Routes.full_route) { FullScreen() }
    }
}