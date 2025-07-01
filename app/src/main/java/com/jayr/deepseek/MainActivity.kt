package com.jayr.deepseek

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayr.deepseek.data.City
import com.jayr.deepseek.data.getDummyCities
import com.jayr.deepseek.ui.theme.DeepseekTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeepseekTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                ) { innerPadding ->
                    Column( modifier = Modifier.padding(innerPadding)) {
                        ExplorerPage()
                        ExplorerPage()
                        ExplorerPage()
                    }
                }
            }
        }
    }
}
@Composable
fun CityCard(title: String, location:String, rating:Float, image:Int){
        Card(
            modifier = Modifier.size(200.dp).padding(12.dp)
        ) {
            Box(
                 contentAlignment = Alignment.BottomCenter
            ){
                Image(
                    painter = painterResource(image),
                    contentDescription = "Image of $title",
                    contentScale = ContentScale.FillBounds
                )
                Card(
                    colors = CardColors(
                        containerColor =Color.White.copy(alpha = 0.6f),
                        contentColor = Color.DarkGray,
                        disabledContainerColor = Color.Gray,
                        disabledContentColor = Color.DarkGray
                    ),
                    modifier = Modifier.width(width = 250.dp).
                height(IntrinsicSize.Min).padding(8.dp) ) {
                    Text(text=title, color = Color.Black, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 12.sp, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = "icon of location",
                            tint = Color.DarkGray,
                            modifier =  Modifier.size(12.dp),
                        )
                        Text(text=location, color = Color.Black,  fontSize = 12.sp, fontWeight = FontWeight.Light)
                        Row (Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically,
                           ){
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "icon of star rating",
                                tint = Color.Yellow,
                               modifier =  Modifier.size(12.dp),

                            )
                            Text(text="$rating", color = Color.Black,  fontSize = 12.sp, fontWeight = FontWeight.Light)
                            Modifier.size(12.dp)
                        }
                    }
                }
            }
        }
}

@Composable
fun ExplorerPage(){
var cities:List<City> = getDummyCities()
    LazyRow {
        items(cities.size) { index ->
            CityCard(
                title = cities[index].name,
                location = cities[index].location,
                rating = cities[index].rating,
                image = cities[index].image,
            )
        }
    }

}



@Composable
fun Places(){
    Box{
        Image(
            painter = painterResource(R.drawable.hotair),
            contentDescription = "Travels Beyond",
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = "Deep dive into the world of travels",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            letterSpacing = 3.sp,
            lineHeight = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
                .padding(8.dp)

        )
    }
    Column (verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())){
        OptionPlace(R.drawable.jeep,"Image of Jeep","Jeep","Jeep at the mountain sides")
        OptionPlace(R.drawable.dive,"Image of Sky Divers","Sky Diving","Sky diving in the Bahamas Boooooooooooooooooooooooyaaaaaaaaaaaaaaaaaaaaaaa!!!")
        OptionPlace(R.drawable.jeep,"Image of Jeep","Jeep","Jeep at the mountain sides")
        OptionPlace(R.drawable.dive,"Image of Sky Divers","Sky Diving","Sky diving in the Bahamas Boooooooooooooooooooooooyaaaaaaaaaaaaaaaaaaaaaaa!!!")
        OptionPlace(R.drawable.jeep,"Image of Jeep","Jeep","Jeep at the mountain sides")
        OptionPlace(R.drawable.dive,"Image of Sky Divers","Sky Diving","Sky diving in the Bahamas Boooooooooooooooooooooooyaaaaaaaaaaaaaaaaaaaaaaa!!!")

    }
   }

@Composable
fun OptionPlace(drawable: Int,description:String,title:String, nameOfPlace:String,   modifier: Modifier=Modifier){
    Card(modifier=modifier
        .padding(10.dp)
        .background(Color.White),
        colors = CardColors(containerColor = Color.White, contentColor = Color.DarkGray, disabledContentColor = Color.Gray, disabledContainerColor = Color.Gray),
        border = BorderStroke(width = 2.dp, brush = Brush.linearGradient(
            listOf(Color.Red, Color.Blue)
        ))
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White)
        ) {
            ImageOfCard(drawable,description)
            Column (modifier.padding(horizontal = 8.dp)){
                Text(text=title, color = Color.DarkGray, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text=nameOfPlace, color = Color.Gray,fontSize = 12.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Composable
fun ImageOfCard(drawable: Int,description:String,  modifier: Modifier=Modifier){
    Image(
        painter = painterResource(drawable),
        contentDescription = description,
        contentScale = ContentScale.FillBounds,
        modifier = modifier
            .size(64.dp)
            .clip(RoundedCornerShape(32.dp))
    )
}

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
        horizontalAlignment = Alignment.Start,
         modifier = Modifier.verticalScroll(rememberScrollState())
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
                        .fillMaxHeight()
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
    var inputValue: MutableState<String> = remember {
        mutableStateOf("...")
    }

    var input:MutableState<String> = remember { mutableStateOf("") }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        TextinputSection("task title","title")

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
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    return screenWidth
}

@Composable
fun PrimaryButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {}
    ) {
        Text(text = text)
    }
}

@Composable
fun TextinputSection(hint: String, label: String, modifier: Modifier = Modifier) {
    var inputValue = remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = listOf(Color.Red, Color.Yellow, Color.Green, Color.Blue, Color.Magenta)
        )
    }
    TextField(
        value = inputValue.value,
        onValueChange = {newValue -> inputValue.value = newValue},
        label = { Text(text=label) },
        textStyle = TextStyle(brush = brush),
        modifier = Modifier.width(getScreenWidth()*2/3),
        leadingIcon = {
            Icon(
            imageVector = Icons.Filled.AccountBox,
                contentDescription = "Acoount "
        ) }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DeepseekTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            ExplorerPage()
        }
    }
}