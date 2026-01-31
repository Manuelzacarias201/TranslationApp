package com.manuelzacarias.api.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manuelzacarias.api.features.home.presentation.HomeScreen
import com.manuelzacarias.api.features.translation.presentation.screens.TranslationScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Translation : Screen("translation")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToTranslation = {
                    navController.navigate(Screen.Translation.route)
                }
            )
        }
        composable(Screen.Translation.route) {
            TranslationScreen()
        }
    }
}
