package com.apps.nb2998.solitare

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

class TableauPileView(ctx: Context, val index: Int) : _RelativeLayout(ctx) {
    init {
        addViews()
    }

    fun update() {
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = GameModel.tableauPiles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(25)).toFloat()
                imageResource = if (card.faceUp) getResourceForCard(card) else cardBackDrawable

                onClick {
                    GamePresenter.onTableauPileTap(index, i)
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}

fun ViewManager.tableauPileView(index: Int, init: TableauPileView.() -> Unit = {}) =
        ankoView({ ctx: Context -> TableauPileView(ctx, index) }, 0, init)