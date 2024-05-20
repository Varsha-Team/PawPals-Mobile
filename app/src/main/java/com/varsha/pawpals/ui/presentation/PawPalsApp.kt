package com.varsha.pawpals.ui.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EventAvailable
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.varsha.pawpals.navigation.NavigationItem
import com.varsha.pawpals.navigation.Screen
import com.varsha.pawpals.ui.presentation.article.ArticleScreen
import com.varsha.pawpals.ui.presentation.article.DetailArticleScreen
import com.varsha.pawpals.ui.presentation.article.ExploreArticleScreen
import com.varsha.pawpals.ui.presentation.community.CommunityScreen
import com.varsha.pawpals.ui.presentation.home.HomeScreen
import com.varsha.pawpals.ui.presentation.profile.EditProfileScreen
import com.varsha.pawpals.ui.presentation.profile.ProfileScreen
import com.varsha.pawpals.ui.presentation.schedule.ScheduleScreen

// Background Color
val backgroundColor = Brush.radialGradient(
    colors = listOf(Color(0xFFFFFFFF), Color(0xFFF2BBB6)),
    center = Offset(540f, 1170f),
    radius = 1500f
)

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PawPalsApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.EditProfile.route) {
                BottomBar(navController = navController)
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Article.route){
                ArticleScreen( navController = navController)
            }

            composable(Screen.Community.route) {
                CommunityScreen()
            }

            composable(Screen.Schedule.route) {
                ScheduleScreen(navController = rememberNavController())
            }

            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }

            composable(Screen.EditProfile.route) {
                EditProfileScreen(navController = rememberNavController())
            }

            composable(
                Screen.ExploreArticle.route + "/{kategoriArtikelId}",
                arguments = listOf(navArgument("kategoriArtikelId"){type = NavType.IntType})
                ){navBackStackEntry ->
                ExploreArticleScreen(
                    navController = navController,
                    kategoriArtikelId = navBackStackEntry.arguments?.getInt("kategoriArtikelId")
                )
            }

            composable(
                Screen.DetailArticle.route + "/{artikelId}",
                arguments = listOf(navArgument("artikelId"){type = NavType.IntType})
                ){navBackStackEntry ->
                DetailArticleScreen(
                    navController = navController,
                    artikelId = navBackStackEntry.arguments?.getInt("artikelId"),
                //    kategoriArtikelId = navBackStackEntry.arguments?.getInt("kategoriArtikelId"),
                  )
            }

        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = Modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                icon = Icons.Outlined.Home,
                screen = Screen.Home
            ),

            NavigationItem(
                icon = Icons.Outlined.Search,
                screen = Screen.Article
            ),

            NavigationItem(
                icon = Icons.Outlined.Newspaper,
                screen = Screen.Community
            ),

            NavigationItem(
                icon = Icons.Outlined.EventAvailable,
                screen = Screen.Schedule
            ),

            NavigationItem(
                icon = Icons.Outlined.PersonOutline,
                screen = Screen.Profile
            )
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },

                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "Icon Bottom Bar",
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PawPalsAppPreview() {
    //PawPalsApp()
}