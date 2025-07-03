package com.jayr.deepseek.data.models

import android.graphics.drawable.Icon
import com.jayr.deepseek.R

data class Facility(
    val icon: Int,
    val text:String
)


fun getDummyFacilities():List<Facility>{
    return listOf(
        Facility( icon=R.drawable.bed, text = "1 Bed"),
        Facility( icon=R.drawable.policeman, text = "Guide"),
        Facility( icon=R.drawable.dinner, text = "Dinner"),
        Facility( icon=R.drawable.gym, text = "Gym"),
    )
}