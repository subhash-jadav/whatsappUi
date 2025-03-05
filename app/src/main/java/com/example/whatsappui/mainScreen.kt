package com.example.whatsappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.whatsappui.ui.theme.darkGreen1

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = "chats_screen",
            modifier = Modifier.weight(1f) // Take the remaining space
        ) {
            composable("chats_screen") { ChatMainScreen() }
            composable("updates_screen") { UpdatesScreen() }
            composable("communities_screen") { CommunitiesScreen() }
            composable("calls_screen") { CallsScreen() }
        }

        BottomNavigationBar(navController = navController)
    }
}

sealed class BottomNavItems(val route: String, val icon: Int, val label: String) {
    object Chats : BottomNavItems("chats_screen", R.drawable.chat, "Chats")
    object Updates : BottomNavItems("updates_screen", R.drawable.updates, "Updates")
    object Communities : BottomNavItems("communities_screen", R.drawable.community, "Communities")
    object Calls : BottomNavItems("calls_screen", R.drawable.phone, "Calls")
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItems.Chats,
        BottomNavItems.Updates,
        BottomNavItems.Communities,
        BottomNavItems.Calls
    )

    BottomNavigation(
        backgroundColor = darkGreen1,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    // Use painterResource to load the image resource dynamically
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(28.dp).padding(bottom = 4.dp), // Adjust the icon size
//                        colorFilter = ColorFilter.tint(Color.White) // Optional: To ensure the icon color is white
                    )
                },
                label = { Text(item.label, color = Color.White) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Avoid multiple copies of the same destination when re-selecting the item
                        popUpTo = navController.graph.startDestinationId
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

