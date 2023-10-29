package com.marmatsan.timematters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.marmatsan.timematters.navigation.SetupNavGraph
import com.marmatsan.timematters.splashscreen.viewmodel.SplashScreenViewModel
import com.marmatsan.timematters.ui.theme.TimeMattersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashScreenViewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            TimeMattersTheme {
                val startDestination by splashScreenViewModel.startDestination.collectAsStateWithLifecycle()
                val snackbarHostState = remember { SnackbarHostState() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { paddingValues ->
                    val navController = rememberNavController()
                    SetupNavGraph(
                        navController = navController,
                        startDestination = startDestination,
                        paddingValues = paddingValues,
                        snackbarHostState = snackbarHostState
                    )
                }
            }
        }
    }
}