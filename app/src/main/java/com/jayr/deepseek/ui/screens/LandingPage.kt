package com.jayr.deepseek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayr.deepseek.R


@Composable
    fun LandingPage(){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){

            Text(
                text = "HotAIR",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            //Circular Image
            Image(
                painter = painterResource(R.drawable.hotair),
                contentDescription = "home",
                modifier = Modifier
                    .size(300.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            //End

        }}
