package com.jayr.deepseek

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
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
import com.jayr.deepseek.data.models.Category
import com.jayr.deepseek.data.models.City
import com.jayr.deepseek.data.models.getDummyCategories
import com.jayr.deepseek.data.models.getDummyCities
import com.jayr.deepseek.ui.theme.DeepseekTheme
import com.jayr.deepseek.ui.theme.sportOrange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeepseekTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        HomePage()
                    }
                }

            }
        }
    }
}


// landing page
@Composable
fun LandingPage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.landing_page),
            contentDescription = "Background image of person exploring the forest",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // first outer column
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
            // contains the text for its a big...outthere go...
            Column(
                modifier = Modifier.padding(vertical = 6.dp)
            ) {
                Text(
                    text = "It's a Big World!",
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )

                Text(
                    text = "Out there, go Explore!",
                    fontSize = 64.sp,
                    lineHeight = 64.sp,
                    letterSpacing = 6.sp,
                    fontWeight = FontWeight.ExtraBold,

                    )
            }
            // buttons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = sportOrange,
                        contentColor = Color.White,
                        disabledContentColor = Color.Gray,
                        disabledContainerColor = Color.DarkGray
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {

                    Text(
                        text = "Get started",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(horizontal = 8.dp),
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Arrow pointing to the right or arrow forward"
                    )

                }
                Text(
                    text = "Privacy Policy",
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable {

                        },
                )
            }


        }

    }


}

//home page

@Composable
fun HomePage() {
    var searchInput: MutableState<String> = remember {
        mutableStateOf("Discover a City")
    }

    val cities: List<City> = getDummyCities()
    val categories: List<Category> = getDummyCategories()


    Column(modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp).fillMaxHeight()) {
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
                        println("Seeing evrything...")
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
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)

        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Images of $text",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp).clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(text = text, fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center)
        }
    }
}

// component for city with ratings card
@Composable
fun CityWithRatingCard(name: String, location: String, rating: Float, image: Int) {
    Card(
        modifier = Modifier
            .size(200.dp)
            .padding(8.dp)
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

@Composable
fun CityCardDetails(image: Int, name: String, rating: Float, location: String) {
    Box() {
        Image(
            painter = painterResource(image),
            contentDescription = "Image of $name in $location"
        )
        Card {
//            location + rating

        }
    }
}
// todo section

@Composable
fun SnackBarItem(text: String, modifier: Modifier) {
    Snackbar {
        Text(text = text)
    }
}

@Composable
fun TodosPage(modifier: Modifier = Modifier) {
    val todoItems: List<TodoItem> = getDummyTasks()

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Your To Do",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        InputSection()
        LazyColumn(
            userScrollEnabled = true,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(vertical = 32.dp)

        ) {
            items(todoItems.size) { item ->
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier

                        .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                        .clickable {
                            println(" Clicked ${todoItems[item].title} task!")
                        }

                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            if (todoItems[item].isComplete) {
                                Icon(
                                    painter = painterResource(R.drawable.task_done),
                                    contentDescription = stringResource(R.string.is_done),
                                    tint = Color.Blue,
                                    modifier = Modifier.padding(horizontal = 8.dp)
                                )
                            } else {
                                Icon(
                                    painter = painterResource(R.drawable.task_not_done),
                                    contentDescription = stringResource(R.string.is_not_done),
                                    tint = Color.Red,
                                    modifier = Modifier.padding(horizontal = 8.dp)
                                )
                            }
                            Text(
                                text = todoItems[item].title,
                                fontSize = 16.sp
                            )

                        }
                        IconButton(onClick = {
                            println(" Delete ${todoItems[item].title} task!")
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.delete),
                                contentDescription = stringResource(R.string.delete_task),
                                tint = Color.Red
                            )
                        }

                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = todoItems[item].description,
                            color = Color.Gray,
                            fontSize = 12.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(horizontal = 8.dp)

                        )

                    }
                }
            }
        }
    }
}

@Composable
fun InputSection(modifier: Modifier = Modifier) {
    var inputValue: String = remember {
        "..."
    }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        TextField(
            value = inputValue,
            onValueChange = { value -> inputValue = value }
        )
        IconButton(
            onClick = {},
            modifier
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray)

        ) {
            Icon(
                painter = painterResource(R.drawable.outline_add_icon),
                contentDescription = stringResource(R.string.add_icon)
            )

        }
    }
}

@Composable
fun TopBar(points: Float, modifier: Modifier = Modifier) {
    Text(
        text = "$points",
        fontSize = 32.sp,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        fontWeight = FontWeight.ExtraBold,
        color = Color.DarkGray
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        fontSize = 32.sp,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(BorderStroke(2.dp, Color.Red))
            .clickable { },
        fontWeight = FontWeight.ExtraBold,
        color = Color.DarkGray
    )
}

@Composable
fun RestingSeat(color: Color, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.baseline_accessible),
        contentDescription = stringResource(R.string.racer_seated_icon),
        colorFilter = ColorFilter.tint(color),
        modifier = modifier
    )
}

@Composable
fun RacingSeat(color: Color, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.outline_accessible_forward),
        contentDescription = stringResource(R.string.racer_seated_icon),
        colorFilter = ColorFilter.tint(color),
        modifier = modifier
    )
}

@Composable
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    return screenWidth
}

@Composable
fun RowAthlete() {
    val screenWidth: Dp = getScreenWidth()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    )
    {
        RacingSeat(Color.DarkGray, modifier = Modifier.size(screenWidth * 1 / 6))
        RestingSeat(Color.Green, modifier = Modifier.size(screenWidth * 1 / 6))
        RacingSeat(Color.Red, modifier = Modifier.size(screenWidth * 1 / 6))
        RestingSeat(Color.Blue, modifier = Modifier.size(screenWidth * 1 / 6))
    }
}

@Composable
fun GameOver() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
    )
    {
        Column {
            Column() {
                RowAthlete()
                RowAthlete()
                RowAthlete()

            }
            Greeting(name = "GAME OVER", modifier = Modifier)

        }
    }
}

@Composable
fun ColumnAthlete() {
    val screenWidth: Dp = getScreenWidth()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    )
    {
        RacingSeat(Color.DarkGray, modifier = Modifier.size(screenWidth * 1 / 6))
        RestingSeat(Color.Green, modifier = Modifier.size(screenWidth * 1 / 6))
        RacingSeat(Color.Red, modifier = Modifier.size(screenWidth * 1 / 6))
        RestingSeat(Color.Blue, modifier = Modifier.size(screenWidth * 1 / 6))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeepseekTheme {
        Column() {
            HomePage()
        }
    }
}