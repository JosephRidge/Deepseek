package com.jayr.deepseek.data.models

data class TodoItem(
    var title:String,
    var description:String,
    var isComplete:Boolean
)


fun getDummyTasks():List<TodoItem>{
    return listOf(
        TodoItem(title = "Wash Dishes", description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ac metus quis ex consectetur vestibulum. Integer lacinia malesuada est id volutpat. Aenean eget augue vehicula, iaculis tellus sodales, euismod ante.", isComplete = false ),
        TodoItem(title = "Wash Car", description = "In mi nisl, molestie nec dolor vel, laoreet laoreet dolor. Mauris pellentesque id dolor eu semper. Maecenas fermentum varius ipsum, et sagittis turpis tincidunt ultrices.", isComplete = true ),
        TodoItem(title = "Read a chapter ", description = "Donec ex ipsum, tincidunt at hendrerit non, efficitur eget turpis. Vestibulum sit amet lectus vulputate, mattis odio non, ultrices velit.", isComplete = false ),
        TodoItem(title = "Clear homework", description = "Proin imperdiet scelerisque nisl id mattis. Integer fermentum eros eu feugiat tempor. In hac habitasse platea dictumst. Nulla elementum molestie lorem, ", isComplete = false )
    )
}

