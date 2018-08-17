package com.apps.nb2998.solitare

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

class WastePileView(ctx: Context) : ImageView(ctx) {
    init {
        imageResource = wastePileDrawable
        onClick {
            GamePresenter.onWastePileTap()
        }
    }

    fun update() {
        val cards = GameModel.wastePile
        imageResource = if (cards.size > 0) getResourceForCard(cards.last()) else wastePileDrawable
    }
}

val WASTEPILE_FACTORY = { ctx: Context -> WastePileView(ctx) }
fun ViewManager.wastePileView(init: WastePileView.() -> Unit = {}) =
        ankoView(WASTEPILE_FACTORY, 0, init)