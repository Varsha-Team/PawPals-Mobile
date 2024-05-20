package com.varsha.pawpals.navigation

import okhttp3.Route

sealed class Screen(val route: String) {

    // MAIN MENU
    data object Home : Screen("home")
    data object Article : Screen("article")
    data object Community : Screen("community")
    data object Schedule : Screen("schedule")
    data object Profile : Screen("profile")

    // OTHERS MENU
    data object Pets : Screen("pets")
    data object ExploreArticle : Screen("explore_article")
    data object DetailArticle : Screen("detail_article")

    data object Onboarding : Screen("onboarding")
    data object Login : Screen("login")
    data object Register: Screen("Register")


}