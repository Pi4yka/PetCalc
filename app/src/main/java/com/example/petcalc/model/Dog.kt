package com.example.petcalc.model

import com.example.petcalc.R


sealed class Dog(
    open val name: String,
    open val breed: String,
    open val size: String? = null,
    open val color: Color = Color.BLACK,
    open val image: Int
) {
    data class Dvornyaga(
        override val size: String?,
        override val name: String,
        override val color: Color,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)

    data class Ovcharka(
        override val size: String?,
        val ohrana: Int,
        override val color: Color,
        override val name: String,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)

    data class Toyterrier(
        override val size: String?,
        override val color: Color,
        override val name: String,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)

    data class Alabay(
        override val size: String?,
        val killpersecond: Int,
        override val color: Color,
        override val name: String,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)

    data class Corgi(
        override val size: String?,
        val bread: String,
        override val color: Color,
        override val name: String,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)

    data class Bulldog(
        override val size: String?,
        override val color: Color,
        override val name: String,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)

    data class Chihuahua(
        override val size: String?,
        override val color: Color,
        override val name: String,
        override val breed: String,
        override val image: Int
    ) : Dog(name = name, breed = breed, image = image)
}

fun getMockDogList(): List<Dog> {
    return listOf(
        Dog.Ovcharka(
            "XL",
            ohrana = 10,
            name = "Zevs",
            color = Color.BROWN,
            breed = "Ovcharka",
            image = R.drawable.ovcharka
        ),
        Dog.Dvornyaga(
            "M",
            name = "Kasper",
            color = Color.BLACK,
            breed = "Dvornyaga",
            image = R.drawable.kasper
        ),
        Dog.Toyterrier(
            "XL",
            name = "Maya",
            color = Color.BLACK,
            breed = "Toyterrier",
            image = R.drawable.maya
        ),
        Dog.Alabay(
            "XXL",
            name = "Demon",
            color = Color.GREEN,
            killpersecond = 100,
            breed = "Alabay",
            image = R.drawable.alabay
        ),
        Dog.Corgi(
            "M",
            name = "Andreas",
            color = Color.BROWN,
            bread = "pie",
            breed = "Corgi",
            image = R.drawable.corgi
        ),
        Dog.Bulldog(
            "L",
            name = "Busya",
            color = Color.GREY,
            breed = "Bulldog",
            image = R.drawable.bulldog
        ),
        Dog.Chihuahua(
            "XS",
            name = "Knopa",
            color = Color.BLUE,
            breed = "Chihuahua",
            image = R.drawable.chihuahua
        ),
        Dog.Toyterrier(
            "S",
            name = "Tom",
            color = Color.GREEN,
            breed = "Toyterrier",
            image = R.drawable.toyterrier
        ),
    )
}

enum class Color {
    BLACK, BROWN, WHITE, GREEN, BLUE, GREY
}


