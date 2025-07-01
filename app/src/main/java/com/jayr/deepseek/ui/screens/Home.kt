package com.jayr.deepseek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayr.deepseek.OptionPlace
import com.jayr.deepseek.R

@Composable
fun Home(){
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