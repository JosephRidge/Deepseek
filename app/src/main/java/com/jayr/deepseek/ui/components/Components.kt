package com.jayr.deepseek.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jayr.deepseek.ui.screens.FavoritesPage
import com.jayr.deepseek.ui.screens.HomePage
import com.jayr.deepseek.ui.screens.LandingPage
import com.jayr.deepseek.ui.screens.PlacePage
import com.jayr.deepseek.ui.screens.ProfilePage
import com.jayr.deepseek.ui.screens.Routes
import com.jayr.deepseek.ui.theme.sportOrange

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


// component => a reusable entity
@Composable
fun TextWithIcon(text: String, icon: ImageVector,
                 fontSize: TextUnit, iconSize: Dp,
                 tint:Color) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 1.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            modifier = Modifier.size(iconSize),
            tint = tint
        )
        Spacer(Modifier.padding(horizontal = 1.5.dp))
        Text(text = text, fontSize = fontSize, color = Color.Black, fontWeight = FontWeight.Light)
        Spacer(Modifier.padding(vertical = 2.dp))
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
                    TextWithIcon(location, Icons.Filled.LocationOn, fontSize = 12.sp, iconSize = 12.dp, tint = Color.White)
                    TextWithIcon("$rating", Icons.Filled.Star, fontSize = 12.sp, iconSize = 12.dp,tint = Color.White)
                }
            }
        }
    }

}

@Composable
fun TitleWithNextButton(text:String, onClick: () -> Unit){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            text = "See all >",
            color = Color.DarkGray,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clickable {
                    onClick
                }
        )
    }
}

@Composable
fun IconButtonComponent(
    onClick:()->Unit,
    imageVector: ImageVector,
    contentDescription:String ){
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = sportOrange
        )
    }
}
@Composable
fun CardWithSmallImage(image:Int, contentDescription:String){
    Card(
        modifier = Modifier.padding(4.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(64.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}
// navigation
@Composable
fun Navigation(navController:NavHostController, innerPaddingValues: PaddingValues){

    NavHost(
        navController = navController,
        startDestination = Routes.Landing.name,
    ) {
         composable(route = Routes.Landing.name){
             LandingPage()
         }
        composable(route = Routes.Home.name){
            HomePage()
        }
        composable(route = Routes.Place.name){
            PlacePage(navController)
        }
        composable(route = Routes.Favorites.name){
            FavoritesPage()
        }
        composable(route = Routes.Profile.name){
            ProfilePage()
        }
    }
}
