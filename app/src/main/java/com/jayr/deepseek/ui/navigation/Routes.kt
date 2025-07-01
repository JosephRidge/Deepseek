package com.jayr.deepseek.ui.navigation

sealed class Routes(val route:String) {

    data object Landing: Routes("landing")
    data object Home: Routes("home")
    data object TargetCity: Routes("city")

}