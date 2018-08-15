val hearts = "Hearts"
val diamonds = "Diamonds"
val spades = "Spades"
val clubs = "Clubs"
val redSuits = arrayOf(hearts, diamonds)
val blackSuits = arrayOf(spades, clubs)

val cardsMap = mapOf(0 to "A", 1 to "2", 2 to "3" , 3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8", 8 to "9", 9 to "10", 10 to "J", 11 to "Q", 12 to "K")

data class Card(val value: Int, val suit: String, var faceUp: Boolean = false){
    override fun toString(): String =  if(faceUp) "${cardsMap[value]}".padEnd(2) + "${getSuitChar(suit)} " else "XXX"

}
fun getSuitChar(suit: String) = when(suit){
    diamonds -> "\u2666"
    clubs -> "\u2663"
    hearts -> "\u2665"
    spades -> "\u2660"
    else -> "Invalid suit"
}

//    companion object {   // could be used; like static in Java
//        val hearts = "Hearts"
//        val diamonds = "Diamonds"
//        val spades = "Spades"
//        val clubs = "Clubs"
//    }