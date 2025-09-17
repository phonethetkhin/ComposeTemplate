package com.example.composetemplate.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Destinations {
    @Serializable
    data object Splash : Destinations

    @Serializable
    data object Home : Destinations


}