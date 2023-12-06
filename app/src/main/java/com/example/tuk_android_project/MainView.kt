package com.example.tuk_android_project

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

class MainView {
    private val menuView = MenuView()

    @Preview(showBackground = true, device = "id:pixel_7_pro", backgroundColor = 0xFFD81B60,
        uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
    )
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PrincipalView(){
        var indexSelected by remember {
            mutableStateOf(0)
        }

        Scaffold(
            topBar = {
                if (indexSelected > 0)
                    TopAppBar(
                        title = {
                            when(indexSelected){
                                1 -> Text(text = "Lessons")
                                2 -> Text(text = "Favorite")
                                3 -> Text(text = "Account")
                            }
                        },
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
            },

            bottomBar = {
                BottomAppBar {
                    NavigationBarItem(
                        selected = indexSelected == 0,
                        onClick = {
                                  indexSelected = 0
                        },
                        label = {
                                Text(text = "Home")
                        },
                        alwaysShowLabel = indexSelected == 0,
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                            selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        icon = { if (indexSelected == 0) Icon(Icons.Filled.Home, contentDescription = "Menu principale") else Icon(Icons.Outlined.Home, contentDescription = "Menu principale") }
                    )

                    NavigationBarItem(
                        selected = indexSelected == 1,
                        onClick = {
                            indexSelected = 1
                        },
                        label = {
                            Text(text = "Lessons")
                        },
                        alwaysShowLabel = indexSelected == 1,
                        icon = { if (indexSelected == 1) Icon(Icons.Filled.Book, contentDescription = "Menu lista") else Icon(Icons.Outlined.Book, contentDescription = "Menu Lista") }
                    )

                    NavigationBarItem(
                        selected = indexSelected == 2,
                        onClick = {
                            indexSelected = 2
                        },
                        label = {
                            Text(text = "Favorite")
                        },
                        alwaysShowLabel = indexSelected == 2,
                        icon = { if (indexSelected == 2) Icon(Icons.Filled.Favorite, contentDescription = "Menu favoriti") else Icon(Icons.Outlined.FavoriteBorder, contentDescription = "Menu favoriti") }
                    )

                    NavigationBarItem(
                        selected = indexSelected == 3,
                        onClick = {
                            indexSelected = 3
                        },
                        label = {
                            Text(text = "Account")
                        },
                        alwaysShowLabel = indexSelected == 3,
                        icon = { if (indexSelected == 3) Icon(Icons.Filled.AccountCircle, contentDescription = "Menu account") else Icon(Icons.Outlined.AccountCircle, contentDescription = "Menu account") }
                    )
                }
            }
        ) { innerPaddings ->
            when(indexSelected){
                0 -> menuView.MenuInitialView(innerPadding = innerPaddings)
                1 -> Text(text = "1")
                2 -> Text(text = "2")
                3 -> Text(text = "3")
            }
        }
    }
}