package com.mecheka.composenews.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mecheka.features.general.GeneralScreen

@Composable
fun NewsNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = General.route, modifier = modifier) {
        composable(General.route) {
            GeneralScreen()
        }
        composable(Business.route) {
            BusinessScreen()
        }
        composable(Tech.route) {
            TechScreen()
        }
    }
}