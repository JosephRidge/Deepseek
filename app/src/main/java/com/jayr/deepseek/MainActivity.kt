package com.jayr.deepseek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jayr.deepseek.data.models.BottomNavBarItem
import com.jayr.deepseek.data.models.Category
import com.jayr.deepseek.data.models.City
import com.jayr.deepseek.data.models.getDummyCategories
import com.jayr.deepseek.data.models.getDummyCities
import com.jayr.deepseek.ui.components.Navigation
import com.jayr.deepseek.ui.screens.HomePage
import com.jayr.deepseek.ui.screens.LandingPage
import com.jayr.deepseek.ui.screens.Routes
import com.jayr.deepseek.ui.theme.DeepseekTheme
import com.jayr.deepseek.ui.theme.sportOrange
import kotlinx.serialization.StringFormat


/**
 * Scenario 1:
 * - using our locally or inbuilt icons: iconSelected when it is selected  if not selected we give the IconSelectedIcon
 * Scenario 2:
 * - using our custome Icon is it is only selected but if it is not we give the custom icon
 *
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeepseekTheme {
                val navigationItems = listOf(
                    BottomNavBarItem(
                        title = Routes.Landing.name,
                        iconSelected = Icons.Filled.Home,
                        iconNotSelected = Icons.Outlined.Home
                    ),
                    BottomNavBarItem(
                        title = Routes.Home.name,
                        iconSelected = Icons.Filled.Search,
                        iconNotSelected = Icons.Outlined.Search
                    ),
                    BottomNavBarItem(
                        title = Routes.Place.name,
                        iconSelected = Icons.Filled.LocationOn,
                        iconNotSelected = Icons.Outlined.LocationOn
                    ),
                    BottomNavBarItem(
                        title = Routes.Favorites.name,
                        iconSelected = Icons.Filled.Favorite,
                        iconNotSelected = Icons.Outlined.FavoriteBorder
                    ),
                    BottomNavBarItem(
                        title = Routes.Profile.name,
                        iconSelected = Icons.Filled.Person,
                        iconNotSelected = Icons.Outlined.Person
                    )
                )
                var selectedItem by rememberSaveable {
                    mutableIntStateOf(0)
                }
                val navController: NavHostController = rememberNavController()

                // current backstack - allows us to get th current page route
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route
                Scaffold(
                    bottomBar =
                        {
                            if (currentRoute != "Landing") {
                                NavigationBar(
                                    containerColor = Color.White
                                ) {
                                    navigationItems.forEachIndexed { index, item ->
                                        NavigationBarItem(
                                            selected = selectedItem == index,
                                            colors = NavigationBarItemColors(
                                                selectedIconColor = sportOrange,
                                                selectedTextColor = sportOrange,
                                                selectedIndicatorColor = Color.White,
                                                unselectedIconColor = Color.Gray,
                                                unselectedTextColor = Color.Gray,
                                                disabledIconColor = Color.Gray,
                                                disabledTextColor = Color.Gray,
                                            ),
                                            onClick = {
                                                selectedItem = index
                                                navController.navigate(route = item.title)
                                                println("Navigations......")
                                            },

                                            icon = {
                                                if (selectedItem == index) {
                                                    item.iconSelected?.let {
                                                        Column(verticalArrangement = Arrangement.SpaceEvenly) {
                                                            Icon(
                                                                imageVector = it,
                                                                contentDescription = "icon of ${item.title}",
                                                                modifier = Modifier.size(24.dp),
                                                                tint = sportOrange
                                                            )

                                                            Icon(
                                                                imageVector = Icons.Filled.ArrowDropDown,
                                                                contentDescription = "icon of arrow facing up",
                                                                modifier = Modifier.scale(
                                                                    scaleX = 1f,
                                                                    scaleY = -1f
                                                                ),
                                                                tint = sportOrange
                                                            )
                                                        }
                                                    }
                                                } else {
                                                    item.iconNotSelected?.let {
                                                        Icon(
                                                            imageVector = it,
                                                            contentDescription = "icon of ${item.title}",
                                                            modifier = Modifier.size(24.dp)
                                                        )
                                                    }
                                                }
                                            },
                                            label = { item.title },
                                        )
                                    }
                                }
                            }
                        },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        Navigation(navController, innerPadding)
                      }
                }
            }
        }
    }
}
