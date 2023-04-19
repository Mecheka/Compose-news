package com.mecheka.composenews

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mecheka.composenews.compose.BottomNavigationHomeScreen
import com.mecheka.composenews.compose.NewsNavHost
import com.mecheka.core.compose.theme.ComposeNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNewsTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomNavigationHomeScreen(navHostController = navController)
                }, modifier = Modifier.fillMaxSize()) { padding ->
                    NewsNavHost(
                        navController = navController,
                        modifier = Modifier.padding(bottom = padding.calculateBottomPadding())
                    )
                }
            }
        }
    }
}