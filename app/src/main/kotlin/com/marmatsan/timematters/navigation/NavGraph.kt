package com.marmatsan.timematters.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marmatsan.heal_th.navigation.Screen
import com.marmatsan.onboarding_ui.screens.OnboardingScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Welcome.route) {
            OnboardingScreen(
                modifier = Modifier.padding(paddingValues)
            )
        }
    }
}