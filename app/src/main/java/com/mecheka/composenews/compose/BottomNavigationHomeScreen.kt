package com.mecheka.composenews.compose

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mecheka.composenews.compose.theme.deepPurple

@SuppressLint("UnrememberedMutableState")
@Composable
fun BottomNavigationHomeScreen(navHostController: NavHostController) {
    val listButtonNavigationItem = listOf(General, Business, Tech)
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        listButtonNavigationItem.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                unselectedContentColor = Color.Black,
                selectedContentColor = deepPurple,
                onClick = {
                    navHostController.navigate(item.route) {
                        navHostController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}