package com.apps.nb2998.solitare
class Deck {

    //    anonymous function to be passed as parameter to Array(); just remove the function name
    //    val cards = Array(52, fun(i: Int): Card {
    //        return Card(i % 13, getSuit(i))
    //    })
    //    OR using lambda expression
    //    val cards = Array(52, { i -> Card(i % 13, getSuit(i) })

    //  when ony 1 parameter, Kotlin creates it for us by the name of "it"

    val cards = Array(52, { Card(it % 13, getSuit(it)) })
    var cardsInDeck : MutableList<Card> = cards.toMutableList()

    fun drawCard() = cardsInDeck.removeAt(0)
    fun reset(){
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach{
            it.faceUp=false
        }
        cardsInDeck.shuffle()
    }

    private fun getSuit(i: Int) = when (i / 13) {
        0 -> clubs
        1 -> diamonds
        2 -> hearts
        else -> spades
    }
}