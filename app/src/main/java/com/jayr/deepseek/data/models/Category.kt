package com.jayr.deepseek.data.models

import com.jayr.deepseek.R

data class Category(
    val name: String,
    val image: Int
)


fun getDummyCategories(): List<Category> {
    return listOf(
        Category(name = "Mountain", image = R.drawable.mountain),
        Category(name = "Camp", image = R.drawable.camp),
        Category(name = "Park", image = R.drawable.park),
        Category(name = "Sailing", image = R.drawable.boat),
        Category(name = "Sky Diving", image = R.drawable.sky)
    )
}
