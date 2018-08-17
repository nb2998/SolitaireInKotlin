package com.apps.nb2998.solitare

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*

const val cardBackDrawable = R.drawable.cardback_green5
const val wastePileDrawable = R.drawable.cardback_blue1
fun View.getResourceForCard(card: Card): Int {
    val resName = "card${card.suit}${cardsMap[card.value]}".toLowerCase()
    return context.resources.getIdentifier(resName, "drawable", context.packageName)
}

class MainActivity : AppCompatActivity(), GameView {
    var deckView: DeckView? = null
    var wastePileView: WastePileView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GamePresenter.view = this
        GameModel.resetGame()

        val cardWidth = (displayMetrics.widthPixels - dip(8))/7
        val cardHeight = cardWidth * 190 / 140

        verticalLayout{
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
//                imageView(imageResource = R.drawable.cardback_green5) // working, but instead create a custom view
//                DeckView(context).lparams(width=cardWidth, height = cardHeight) // did not work, did not call ankoview anywhere

                deckView = deckView().lparams(cardWidth, cardHeight)

//                imageView(imageResource = wastePileDrawable).lparams(width=cardWidth, height = cardHeight)
                wastePileView = wastePileView().lparams(cardWidth, cardHeight)

                view().lparams(width= cardWidth, height = 0)
                for(i in 0..3) imageView(imageResource = wastePileDrawable).lparams(width=cardWidth, height = cardHeight)
            }

            linearLayout {

            }
        }
    }

    override fun update(gameModel: GameModel) {
        deckView!!.update()
        wastePileView!!.update()
    }
}