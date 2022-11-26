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
}

val zevs = Dog.Ovcharka("XL", ohrana = 10, name = "zevs", color = Color.BLACK)
val kasper = Dog.Dvornyaga("M", name = "kasper", color = Color.BLACK)

val list: List<Dog> = listOf(
    zevs, kasper
)


fun getDvornyag(list: List<Dog>?) {
    list?.forEach {
        when (it) {
            is Dog.Dvornyaga -> TODO()
            is Dog.Ovcharka -> TODO()
        }
    }

    val response = Response(dogId = 1, dogName = null)
    val result = DogView(
        name = response.dogName ?: "kasper"
    )
}

data class Response(
    val dogId: Int,
    val dogName: String?
)

data class DogView(
    val name: String
)


enum class Color {
    RED, BLUE, BLACK
}


