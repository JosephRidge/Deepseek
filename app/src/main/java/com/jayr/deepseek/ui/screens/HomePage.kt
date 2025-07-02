package com.jayr.deepseek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayr.deepseek.R
import com.jayr.deepseek.data.models.Category
import com.jayr.deepseek.data.models.City
import com.jayr.deepseek.data.models.getDummyCategories
import com.jayr.deepseek.data.models.getDummyCities
import com.jayr.deepseek.ui.components.CityWithRatingCard
import com.jayr.deepseek.ui.components.TextWithImage
import com.jayr.deepseek.ui.theme.sportOrange


@Composable
fun HomePage() {
    val searchInput: MutableState<String> = remember {
        mutableStateOf("Discover a City")
    }

    val cities: List<City> = getDummyCities()
    val categories: List<Category> = getDummyCategories()


    Column(modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp)
        .fillMaxHeight()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            // greetings
            Row {
                Text(text = "Hi, ", fontSize = 16.sp)
                Text(text = "SuperMario", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Image(
                painter = painterResource(R.drawable.super_mario),
                contentDescription = "Profile image of user - super mario",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .border(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Red, Color.Blue, Color.Green),
                            startX = 0.0f,
                            endX = 500.0f,
                            tileMode = TileMode.Repeated
                        ),
                        width = 4.dp,
                        shape = RoundedCornerShape(32.dp)
                    )
            )
        }

        // text 1
        Text(
            text = "Where do you want to go?",
            fontSize = 24.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        // input/ search section
        TextField(
            value = searchInput.value,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search icon",
                    tint = sportOrange
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.filter),
                    contentDescription = "filter button",
                    tint = sportOrange
                )
            },

            onValueChange = { newValue ->
                searchInput.value = newValue
            }
        )
        // city section
        Text(
            text = "Explore Cities",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            Text(text = "All", color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
            Text(
                text = "Popular",
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "Reccommended",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "Most Viewed",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "Recently Viewed",
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

        }
        // city cards with ratings
        // Lazy layouts (lazyrow and lazycolumns ) are best
        // suited for dynamic data but row, columns are suitable for static data
        LazyRow {
            items(cities.size) { index ->
                CityWithRatingCard(
                    name = cities[index].name,
                    location = cities[index].location,
                    rating = cities[index].rating,
                    image = cities[index].image
                )

            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Categories",
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
                        println("Seeing everything...")
                    }
            )
        }

        // categories
        LazyRow {
            items(categories.size) { index ->
                TextWithImage(
                    text = categories[index].name,
                    image = categories[index].image
                )
            }
        }
    }
}