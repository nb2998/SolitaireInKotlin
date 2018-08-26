package com.apps.nb2998.solitare

class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init { // last card should face up
        if (cards.isNotEmpty()) cards.last().faceUp = true
    }

    fun addCard(newCards: MutableList<Card>): Boolean {
        if (cards.size > 0) {
            if (cards.last().value == newCards.first().value + 1 && suitCheck(cards.last(), newCards.first())) {
                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().value == 12) {
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex: Int) {
        for (i in tappedIndex..cards.lastIndex) {
            cards.removeAt(tappedIndex)
        }
        if (cards.size > 0) {
            cards.last().faceUp = true
        }
    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        if (c1.suit in redSuits && c2.suit in blackSuits) return true
        if (c1.suit in blackSuits && c2.suit in redSuits) return true
        return false
    }

    fun addCardWhenEmptyPile(newCards: MutableList<Card>): Boolean {
        if (cards.size == 0) {
            cards.addAll(newCards)
            return true
        }
        return false
    }
}