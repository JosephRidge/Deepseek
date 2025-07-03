package com.jayr.deepseek.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jayr.deepseek.R
import com.jayr.deepseek.ui.components.SmallImageWithCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacePage(){

    Box(
    ){
        Image(
            painter = painterResource(R.drawable.camp),
            contentDescription = "Image of place ",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .matchParentSize()
        )
        Column(
            modifier = Modifier
                .padding(  horizontal = 8.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()

            ){
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp)
                        .size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "image of back arrow",
                        tint = Color.Gray,

                    )
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .padding(4.dp)
                        .size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "image of like button",
                        tint = Color.Gray,

                    )
                }

            }

            Row(horizontalArrangement = Arrangement.Center ,
                modifier = Modifier.fillMaxWidth()) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White.copy(alpha = 0.5f))
                        .padding(4.dp)
                ) {
                    SmallImageWithCard(text="mountain", image = R.drawable.mountain)
                    SmallImageWithCard(text="Boat", image = R.drawable.boat)
                    SmallImageWithCard(text="mountain", image = R.drawable.mountain)
                }
            }
            ModalBottomSheet (
                onDismissRequest = {},
                modifier = Modifier
               .fillMaxWidth()){
               Text(text = "Welcome ot the places")
           }
        }

    }
}