package com.jayr.deepseek.ui.screens

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowInsetsAnimationCompat.Callback
import androidx.navigation.NavHostController
import com.jayr.deepseek.R
import com.jayr.deepseek.data.models.Facility
import com.jayr.deepseek.data.models.getDummyFacilities
import com.jayr.deepseek.ui.components.CardWithSmallImage
import com.jayr.deepseek.ui.components.IconButtonComponent
import com.jayr.deepseek.ui.components.TextWithIcon
import com.jayr.deepseek.ui.components.TitleWithNextButton
import com.jayr.deepseek.ui.theme.lightGray
import com.jayr.deepseek.ui.theme.sportOrange

@Composable
fun getScreenWidth(): Dp {
    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    return screenWidth
}
@Composable
fun PlacePage(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.china_great_wall),
            contentDescription = "Image of GreatWall Of china",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()

        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {

                IconButtonComponent(
                    onClick = { },
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = "Icon of back button"
                )
                IconButtonComponent(
                    onClick = {},
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Icon of like button"
                )
            }


            Column{

            // snippest of the placess
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White.copy(alpha = 0.2f))
                        .padding(4.dp)
                ) {
                    CardWithSmallImage(
                        image = R.drawable.camp,
                        contentDescription = "Image of camp"
                    )
                    CardWithSmallImage(
                        image = R.drawable.boat,
                        contentDescription = "Image of boat"
                    )
                    CardWithSmallImage(
                        image = R.drawable.hungary,
                        contentDescription = "Image of parliament in hungary"
                    )
                    CardWithSmallImage(
                        image = R.drawable.park,
                        contentDescription = "Image of bicycle"
                    )
                }
            }

            // place details
            Card(
                colors = CardColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.DarkGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(32.dp))

            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp).
                    verticalScroll(
                        rememberScrollState()
                    )
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Passo Rolle, TN",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )

                        TextWithIcon(
                            text = "4.7(9K review)",
                            icon = Icons.Outlined.Star,
                            fontSize = 16.sp,
                            iconSize = 16.dp,
                            tint = sportOrange
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        TextWithIcon(
                            text = "Italia",
                            icon = Icons.Outlined.LocationOn,
                            fontSize = 12.sp,
                            iconSize = 16.dp,
                            tint = Color.DarkGray
                        )

                        TextWithIcon(
                            text = "Map Direction",
                            icon = Icons.Outlined.LocationOn,
                            fontSize = 12.sp,
                            iconSize = 16.dp,
                            tint = sportOrange
                        )
                    }
                    HorizontalDivider(
                        color = Color.Gray,
                        thickness = 1.5.dp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                    TitleWithNextButton(text = "Facilities", {})

                    val facilityTypes: List<Facility> = getDummyFacilities()

                    // display facilities
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(facilityTypes.size) { index ->
                            Card(
                                colors = CardColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black,
                                    disabledContainerColor = Color.LightGray,
                                    disabledContentColor = Color.DarkGray
                                ),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 2.dp
                                ),
                                modifier = Modifier.padding(horizontal = 4.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(4.dp)
                                ) {
                                    Image(
                                        painter = painterResource(facilityTypes[index].icon),
                                        contentDescription = "Image of bed",
                                        colorFilter = ColorFilter.tint(Color.DarkGray),
                                        modifier = Modifier
                                            .height(32.dp)
                                            .width(32.dp)
                                            .clip(
                                                RoundedCornerShape(12.dp)
                                            )
                                            .background(lightGray)
                                            .padding(8.dp)
                                    )
                                    Text(
                                        text = facilityTypes[index].text
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.padding(vertical =0.5.dp))
// description section
                    Text(
                        text = "Description",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )

                    Text(
                        text = stringResource(R.string.dummy_text),
                        color = Color.Gray,
                        maxLines =2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 12.sp,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // indicates the price
                        Column(
                            modifier = Modifier.padding(horizontal = 12.dp)
                        ) {
                            Text(
                                text = "$780",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.ExtraBold,

                            )
                            Text(
                                text = "/ person",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }

                        var screenWidth:Dp = getScreenWidth()

                        // indicates the button
                        Button(
                            colors = ButtonColors(
                                containerColor = sportOrange,
                                contentColor = Color.White,
                                disabledContainerColor = Color.Gray,
                                disabledContentColor = Color.DarkGray
                            ),
                            onClick = {},
                            modifier = Modifier.fillMaxHeight().fillMaxWidth() .padding(horizontal = 8.dp)

                        ) {
                            Text(text="Book Now",
                                modifier = Modifier.padding(vertical = 8.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = "Image of arrow forward",
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        }
                    }

                }


            }
            }

        }
    }
}