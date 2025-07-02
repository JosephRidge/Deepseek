package com.jayr.deepseek

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.compose.rememberNavController
import com.jayr.deepseek.data.models.BottomNavBarItem
import com.jayr.deepseek.data.models.Category
import com.jayr.deepseek.data.models.City
import com.jayr.deepseek.data.models.getDummyCategories
import com.jayr.deepseek.data.models.getDummyCities
import com.jayr.deepseek.ui.components.Navigation
import com.jayr.deepseek.ui.screens.HomePage
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
                        iconSelected =  Icons.Filled.Home,
                        iconNotSelected = Icons.Outlined.Home
                    ),
                    BottomNavBarItem(
                        title = Routes.Home.name,
                        iconSelected = Icons.Filled.Search,
                        iconNotSelected = Icons.Outlined.Search
                    ),
                    BottomNavBarItem(
                        title = Routes.Place.name,
                        iconSelected =  Icons.Filled.LocationOn,
                        iconNotSelected = Icons.Outlined.LocationOn
                    ),
                    BottomNavBarItem(
                        title = Routes.Place.name,
                        iconSelected =  Icons.Filled.Favorite,
                        iconNotSelected = Icons.Outlined.Favorite
                    ),
                    BottomNavBarItem(
                        title = Routes.Place.name,
                        iconSelected =  Icons.Filled.Person,
                        iconNotSelected = Icons.Outlined.Person
                    )
                )
                var selectedItem by rememberSaveable {
                    mutableStateOf(0)
                }
                var navController: NavHostController = rememberNavController()
                Scaffold(

                    bottomBar =
                        {
                            NavigationBar(
                                modifier = Modifier.background(Color.Gray)
                            ){
                                navigationItems.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItem == index,
                                        onClick = {
                                            selectedItem = index
                                            navController.navigate(route=item.title)
                                            println("Navigations......")
                                        },

                                        icon = {
                                            if(selectedItem == index){
                                                item.iconSelected?.let {
                                                    Icon(
                                                        imageVector = it,
                                                        contentDescription = "icon of ${item.title}",
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                            }else{
                                                item.iconNotSelected?.let {
                                                    Icon(
                                                        imageVector = it,
                                                        contentDescription = "icon of ${item.title}",
                                                        modifier = Modifier.size(24.dp)
                                                    )
                                                }
                                            }
                                        },
                                        label = { item.title},
                                    )
                                }

                            }
                        },
//                    modifier = Modifier
//                        .fillMaxSize()
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){

                        Navigation(navController)
                    }
                }

            }
        }
    }
}


// component => a reusable entity
@Composable
fun TextWithIcon(text: String, icon: ImageVector) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(12.dp),
            tint = Color.White
        )
        Spacer(Modifier.padding(horizontal = 1.5.dp))
        Text(text = text, fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Light)
        Spacer(Modifier.padding(vertical = 2.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeepseekTheme {
            var navigationItems = listOf(
                BottomNavBarItem(
                    title = Routes.Landing.name,
                    iconSelected =  Icons.Filled.Home,
                    iconNotSelected = Icons.Outlined.Home
                ),
                BottomNavBarItem(
                    title = Routes.Home.name,
                    iconSelected = Icons.Filled.Search,
                    iconNotSelected = Icons.Outlined.Search
                ),
                BottomNavBarItem(
                    title = Routes.Place.name,
                    iconSelected =  Icons.Filled.LocationOn,
                    iconNotSelected = Icons.Outlined.LocationOn
                ),
                BottomNavBarItem(
                    title = Routes.Place.name,
                    iconSelected =  Icons.Filled.Favorite,
                    iconNotSelected = Icons.Outlined.Favorite
                ),
                BottomNavBarItem(
                    title = Routes.Place.name,
                    iconSelected =  Icons.Filled.Person,
                    iconNotSelected = Icons.Outlined.Person
                )
            )
            var selectedItem by rememberSaveable {
                mutableStateOf(0)
            }
            val navController:NavHostController =   rememberNavController()
            Scaffold(

                bottomBar =
                    {
                        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                            navigationItems.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = selectedItem == index,
                                    onClick = {
                                        selectedItem = index
                                        navController.navigate(route=item.title)
                                    },

                                            icon = {
                                        if(selectedItem == index){
                                            item.iconSelected?.let {
                                                Icon(
                                                    imageVector = it,
                                                    contentDescription = "icon of ${item.title}",
                                                    modifier = Modifier.size(24.dp)
                                                )
                                            }
                                        }else{
                                            item.iconNotSelected?.let {
                                                Icon(
                                                    imageVector = it,
                                                    contentDescription = "icon of ${item.title}",
                                                    modifier = Modifier.size(24.dp)
                                                )
                                            }
                                        }
                                    },
                                    label = { item.title},
                                )
                            }

                        }
                    },
                modifier = Modifier
            ) { innerPadding ->

               Box(modifier = Modifier.padding(innerPadding)){

                   Navigation(navController)
               }
            }

        }
}