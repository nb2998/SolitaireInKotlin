package com.apps.nb2998.solitare

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

class FoundationPileView(ctx: Context, val index: Int): ImageView(ctx) {
    init {
        imageResource = wastePileDrawable
        onClick {
            GamePresenter.onFoundationPileTap(index)
        }
    }

    fun update(){
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if(cards.isNotEmpty()) getResourceForCard(cards[index]) else wastePileDrawable
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit={})=
        ankoView({ctx:Context->FoundationPileView(ctx, index)}, 0, init)