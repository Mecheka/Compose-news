package com.mecheka.composenews.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mecheka.feature.business.BusinessScreenCompose
import com.mecheka.feature.general.GeneralScreenCompose

@Composable
fun NewsNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = General.route, modifier = modifier) {
        composable(General.route) {
            GeneralScreenCompose()
        }
        composable(Business.route) {
            BusinessScreenCompose()
        }
        composable(Tech.route) {
            TechScreen()
        }
    }
}