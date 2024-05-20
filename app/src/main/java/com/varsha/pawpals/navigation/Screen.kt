package com.varsha.pawpals.navigation

import okhttp3.Route

sealed class Screen(val route: String) {

    // MAIN MENU (NavBottom)
    data object Home : Screen("home")
    data object Article : Screen("article")
    data object Community : Screen("community")
    data object Schedule : Screen("schedule")
    data object Profile : Screen("profile")

    // OTHERS MENU
    data object Pets : Screen("pets")

    // MENU Notification
    data object Notification : Screen("notification")

    //Profil Screen User
    data object EditProfile : Screen("editScreen")
    data object Logout : Screen("logout")
}