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
    data object ExploreArticle : Screen("explore_article")
    data object DetailArticle : Screen("detail_article")

    // MENU Notification
    data object Notification : Screen("notification")

    //Bookmark
    data object Bookmark : Screen("bookmark")

    //Profil Screen User
    data object EditProfile : Screen("editScreen")
    data object Logout : Screen("logout")
    data object Onboarding : Screen("onboarding")
    data object Login : Screen("login")
    data object Register: Screen("Register")

    //Schedule Pet
    data object AddPet : Screen("add_pet")
    data object EditPet : Screen("edit_pet")

    data object PlanPet : Screen("plan_pet")

    data object EditPlan : Screen("edit_plan")

    // Community Menu
    data object CommunityDetail : Screen("community_detail")
    //Post Screen
    data object PostScreen : Screen("post_screen")

    // Splash Screen
    data object Splash : Screen("splash")


}