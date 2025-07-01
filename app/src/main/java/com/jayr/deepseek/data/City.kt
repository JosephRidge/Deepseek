package com.jayr.deepseek.data

import android.media.Image
import com.jayr.deepseek.R

data class City(
    val name:String,
    val location:String,
    val rating:Float,
    val image: Int
)


fun getDummyCities():List<City>{
    return listOf(
        City("Mar Caribue, avenda lage","Thailand",4.9f, R.drawable.thailand),
        City("Great Wall of China Town","China",4.9f, R.drawable.china),
        City("Parliament palace in Italia","Italy",4.9f, R.drawable.italy),
        City("Beautiful Spain Metropolis ","Spain",4.9f, R.drawable.spain),
    )
}