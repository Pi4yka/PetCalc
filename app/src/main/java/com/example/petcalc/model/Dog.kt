package com.example.petcalc.model

sealed class Dog(
    open val name: String,
    open val size: String? = null,
    open val color: Color = Color.BLACK
) {
    data class Dvornyaga(
        override val size: String?,
        override val name: String,
        override val color: Color,
    ) : Dog(name = name)

    data class Ovcharka(
        override val size: String?,
        val ohrana: Int,
        override val color: Color,
        override val name: String
    ) : Dog(name = name)

    data class Toyterrier(
        override val size: String?,
        override val color: Color,
        override val name: String
    ) : Dog(name = name)

    data class Alabay(
        override val size: String?,
        val killpersecond: Int,
        override val color: Color,
        override val name: String
    ) : Dog(name = name)

    data class Corgi(
        override val size: String?,
        val bread: String,
        override val color: Color,
        override val name: String
    ) : Dog(name = name)
}

val zevs = Dog.Ovcharka("XL", ohrana = 10, name = "zevs", color = Color.BLACK)
val kasper = Dog.Dvornyaga("M", name = "kasper", color = Color.BLACK)
val tom = Dog.Toyterrier("S", name = "tom", color = Color.BROWN)
val demon = Dog.Alabay("XXL", name = "demon", color=Color.GREEN, killpersecond = 100)
val andreas = Dog.Corgi("M", name = "anreas", color = Color.WHITE, bread = "pie")


//val list: List<Dog> = listOf(
//    zevs, kasper, tom, demon, andreas
//)

enum class Color {
    RED, BLUE, BLACK, BROWN, GREEN, WHITE
}


