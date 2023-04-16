package com.mecheka.composenews.compose

import androidx.annotation.DrawableRes
import com.mecheka.composenews.R

sealed class BottomNavigationItem(val title: String, val route: String, @DrawableRes val icon: Int)
object General :
    BottomNavigationItem(title = "General", route = "general", icon = R.drawable.ic_general)

object Business :
    BottomNavigationItem(title = "Business", route = "business", icon = R.drawable.ic_business)

object Tech : BottomNavigationItem(title = "Tech", route = "tech", icon = R.drawable.ic_tech)