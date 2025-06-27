package com.jayr.deepseek

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        .padding(16.dp)
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        TodosPage()
                    }
                }
            }
        }
    }
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
        Column {
            Greeting("Deepseek")
            RestingSeat(Color.Blue, modifier = Modifier.size(32.dp))
            RacingSeat(Color.Blue, modifier = Modifier)
        }
    }
}