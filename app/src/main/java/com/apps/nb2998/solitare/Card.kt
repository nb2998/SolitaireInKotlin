val hearts = "Hearts"
val diamonds = "Diamonds"
val spades = "Spades"
val clubs = "Clubs"
val redSuits = arrayOf(hearts, diamonds)
val blackSuits = arrayOf(spades, clubs)

data class Card(val value: Int, val suit: String, var faceUp: Boolean = false)

//    companion object {   // could be used; like static in Java
//        val hearts = "Hearts"
//        val diamonds = "Diamonds"
//        val spades = "Spades"
//        val clubs = "Clubs"
//    }
