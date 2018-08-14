class GameModel {
    val deck= Deck()
    val wastePile : MutableList<Card> = mutableListOf()
    val foundationPile:Array<FoundationPile> = arrayOf(FoundationPile(spades), FoundationPile(hearts),
            FoundationPile(diamonds), FoundationPile(clubs))
    val tableauPile = arrayOf(7, TableauPile())
}