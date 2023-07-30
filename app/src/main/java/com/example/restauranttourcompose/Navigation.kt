package com.example.restauranttourcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restauranttourcompose.ui.home.HomeScreen
import com.example.restauranttourcompose.ui.restaurantdetails.RestaurantDetailScreen

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object RestaurantDetails : Routes("restaurantDetails/{id}")
}

@Composable
fun RestaurantTourNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.RestaurantDetails.route
    ) {
        composable(Routes.Home.route) {
            HomeScreen()
        }

        composable(Routes.RestaurantDetails.route) {
            RestaurantDetailScreen(
                onNavBack = { navController.navigateUp() },
                onReviewTap = { }
            )
        }
    }
}