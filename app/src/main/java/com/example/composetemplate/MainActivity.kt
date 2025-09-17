package com.example.composetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.composetemplate.ui.navigation.Destinations
import com.example.composetemplate.ui.navigation.appNavGraph
import com.example.composetemplate.ui.navigation.rememberNavigator
import com.example.composetemplate.ui.theme.MyanmarBirdsTheme
import dagger.hilt.android.AndroidEntryPoint

private val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition) =
    { fadeIn(animationSpec = tween(300)) }
private val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition) =
    { fadeOut(animationSpec = tween(300)) }

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyanmarBirdsTheme {
                val navController = rememberNavController()
                val navigator = rememberNavigator(navController = navController)

                NavHost(
                    modifier = Modifier
                        .fillMaxSize(),
                    navController = navController,
                    startDestination = Destinations.Home,
                    enterTransition = enterTransition,
                    exitTransition = exitTransition,
                    popEnterTransition = enterTransition,
                    popExitTransition = exitTransition,
                ) {
                    appNavGraph(navigator = navigator)
                }
            }
        }
    }
}

