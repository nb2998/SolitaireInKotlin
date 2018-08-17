package com.apps.nb2998.solitare

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

class DeckView(ctx: Context) : ImageView(ctx) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GamePresenter.onDeckTap()
        }
    }

    fun update() {
        val cards = GameModel.deck.cardsInDeck
        imageResource = if (cards.size > 0) cardBackDrawable else wastePileDrawable
    }
}

val DECKVIEW_FACTORY = { ctx: Context -> DeckView(ctx) }
fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
        ankoView(DECKVIEW_FACTORY, 0, init)