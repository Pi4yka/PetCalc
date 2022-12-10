import androidx.annotation.DrawableRes
import com.example.petcalc.R

data class Diablo(
    val id: Int,
    val name: String,
    val build: String,
    @DrawableRes
    val imageResId: Int
)

fun getMockDiabloStartList(): List<Diablo> = listOf(
    Diablo(
        id = 1,
        name = "Necromancer",
        build = "Trag'Oul Death Nova",
        imageResId = R.drawable.necromancer
    ),
    Diablo(
        id = 2,
        name = "Monk",
        build = "LoD Wave Of Light",
        imageResId = R.drawable.monk
    )
)

fun getMockDiabloList(): List<Diablo> = listOf(
    Diablo(
        id = 3,
        name = "Demon Hunter",
        build = "Shadow Impale",
        imageResId = R.drawable.demonhunter
    ),
    Diablo(
        id = 4,
        name = "Barbarian",
        build = "LoD HotA",
        imageResId = R.drawable.monk
    ),
    Diablo(
        id = 5,
        name = "Crusader",
        build = "LoN Bombardment",
        imageResId = R.drawable.monk
    ),
    Diablo(
        id = 6,
        name = "Witch Doctor",
        build = "Zunimassa Poison Dart",
        imageResId = R.drawable.monk
    ),
    Diablo(
        id = 7,
        name = "Wizard",
        build = "LoD 'Bazooka' Meteor",
        imageResId = R.drawable.monk
    )
)

