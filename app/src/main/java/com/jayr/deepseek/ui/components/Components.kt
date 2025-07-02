package com.jayr.deepseek.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jayr.deepseek.TextWithIcon
import com.jayr.deepseek.ui.screens.FavoritesPage
import com.jayr.deepseek.ui.screens.HomePage
import com.jayr.deepseek.ui.screens.LandingPage
import com.jayr.deepseek.ui.screens.PlacePage
import com.jayr.deepseek.ui.screens.ProfilePage
import com.jayr.deepseek.ui.screens.Routes

@Composable
fun TextWithImage(text: String, image: Int) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.DarkGray,
            disabledContainerColor = Color.DarkGray,
            disabledContentColor = Color.Gray
        ),
        modifier = Modifier.padding(8.dp).height(150.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp).fillMaxHeight()

        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Images of $text",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(text = text, fontWeight = FontWeight.Light, color = Color.Black,
                textAlign = TextAlign.Center)
        }
    }
}



// component for city with ratings card
@Composable
fun CityWithRatingCard(name: String, location: String, rating: Float, image: Int) {
    Card(
        modifier = Modifier
            .size(180.dp)
            .padding(4.dp)
    )
    {
        Box(
            contentAlignment = Alignment.BottomCenter,
        ) {
            // background image
            Image(
                painter = painterResource(image),
                contentDescription = "Image of $name",
                contentScale = ContentScale.FillBounds
            )
            Card(
                colors = CardColors(
                    containerColor = Color.White.copy(alpha = 0.5f),
                    contentColor = Color.Black,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray
                ),
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Text(
                    text = name, fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 1, overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Row {
                    TextWithIcon(location, Icons.Filled.LocationOn)
                    TextWithIcon("$rating", Icons.Filled.Star)
                }
            }
        }
    }

}

// navigation

@Composable
fun Navigation(navController:NavHostController){

    NavHost(
        navController = navController,
        startDestination = Routes.Landing.name,
//        modifier = Modifier.fillMaxSize()
    ) {
         composable(route = Routes.Landing.name){
             LandingPage()
         }
        composable(route = Routes.Home.name){
            HomePage()
        }
        composable(route = Routes.Place.name){
            PlacePage()
        }
        composable(route = Routes.Favorites.name){
            FavoritesPage()
        }
        composable(route = Routes.Profile.name){
            ProfilePage()
        }
    }
}
