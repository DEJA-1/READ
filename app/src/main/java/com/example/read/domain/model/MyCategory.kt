package com.example.read.domain.model

data class MyCategory(
    val name: String,
    val image: String
)

fun loadCategories(): List<MyCategory> {
    return listOf(
        MyCategory(
            name = "Money",
            image = "https://images.pexels.com/photos/47344/dollar-currency-money-us-dollar-47344.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "War",
            image = "https://images.pexels.com/photos/78783/submachine-gun-rifle-automatic-weapon-weapon-78783.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Business",
            image = "https://images.pexels.com/photos/3183197/pexels-photo-3183197.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Food",
            image = "https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Real estate",
            image = "https://images.pexels.com/photos/162031/dubai-tower-arab-khalifa-162031.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Well being",
            image = "https://images.pexels.com/photos/6787202/pexels-photo-6787202.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Success",
            image = "https://images.pexels.com/photos/327533/pexels-photo-327533.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Travel",
            image = "https://images.pexels.com/photos/725255/pexels-photo-725255.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Time",
            image = "https://images.pexels.com/photos/1095601/pexels-photo-1095601.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        ),
        MyCategory(
            name = "Law",
            image = "https://images.pexels.com/photos/5669602/pexels-photo-5669602.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
        )
    )
}


