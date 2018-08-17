package com.apps.nb2998.solitare

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import org.jetbrains.anko.*

const val cardBackDrawable = R.drawable.cardback_green5
const val wastePileDrawable = R.drawable.cardback_blue1
val Context.cardWidth: Int
    get() = (displayMetrics.widthPixels - dip(8)) / 7
val Context.cardHeight: Int
    get() = cardWidth * 190 / 140

fun View.getResourceForCard(card: Card): Int {
    val resName = "card${card.suit}${cardsMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resName, "drawable", context.packageName)
}

class MainActivity : AppCompatActivity(), GameView {
    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null
    var foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)
    var tableauPileViews: Array<TableauPileView?> = arrayOfNulls(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.view = this
        GameModel.resetGame()

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
                //                imageView(imageResource = R.drawable.cardback_green5) // working, but instead create a custom view
//                DeckView(context).lparams(width=cardWidth, height = cardHeight) // did not work, did not call ankoview anywhere

                deckView = deckView().lparams(cardWidth, cardHeight)

//                imageView(imageResource = wastePileDrawable).lparams(width=cardWidth, height = cardHeight)
                wastePileView = wastePileView().lparams(cardWidth, cardHeight)

                view().lparams(width = cardWidth, height = 0)
                for (i in 0..3) {
//                    imageView(imageResource = wastePileDrawable).lparams(width=cardWidth, height = cardHeight)
                    foundationPileViews[i] = foundationPileView(i).lparams(cardWidth, cardHeight)
                }
            }

            linearLayout {
                for(i in 0..6) {
                    tableauPileViews[i] = tableauPileView(i).lparams(cardWidth, matchParent)
                }
            }.lparams(height = matchParent){
                topMargin = cardHeight/2
            }
        }
    }

    override fun update(gameModel: GameModel) {
        deckView!!.update()
        wastePileView!!.update()
        foundationPileViews.forEach {
            it!!.update()
        }
        tableauPileViews.forEach {
            it!!.update()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("Reset Game")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}