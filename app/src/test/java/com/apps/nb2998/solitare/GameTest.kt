package com.apps.nb2998.solitare
import org.junit.Test

class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        //arrange
        var numGames = 0
        val maxGames = 10000

        //act
        for (i in 1..maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWastePileTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauPileTap(index, tableauPile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) break
        }

        //assert
        GameModel.debugPrint()
        println()
        println("munGames: $numGames")
        println("size of 0: ${GameModel.foundationPiles[0].cards.size}")
        assert(numGames < maxGames)
    }
}
