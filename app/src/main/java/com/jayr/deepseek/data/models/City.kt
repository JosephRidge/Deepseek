package com.jayr.deepseek.data.models

import com.jayr.deepseek.R

data class City(
    val name:String,
    val location:String,
    val image:Int,
    val rating: Float
)



fun getDummyCities():List<City>{
    return listOf(
        City(name = "Parliament building of Ukraine",location = "Ukraine", rating = 4.4f , image = R.drawable.ukraine),
        City(name = "Parliament building of Hungary",location = "Hungary", rating = 4.4f , image = R.drawable.hungary),
        City(name = "Parliament building of Italy",location = "Italy", rating = 4.4f , image = R.drawable.italy),
        City(name = "China Great Wall building of Italy",location = "China", rating = 4.4f , image = R.drawable.china_great_wall),
    )
}
