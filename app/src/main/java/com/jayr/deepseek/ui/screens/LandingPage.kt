package com.jayr.deepseek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
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
import com.jayr.deepseek.R
import com.jayr.deepseek.ui.theme.sportOrange


// landing page
@Composable
fun LandingPage( innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.landing_page),
            contentDescription = "Background image of person exploring the forest",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()

        )

        // first outer column
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
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