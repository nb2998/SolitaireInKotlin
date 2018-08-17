package com.apps.nb2998.solitare
object GamePresenter {
    var view: GameView? = null
    fun onDeckTap() {
        GameModel.onDeckTap()
        view?.update()
    }

    fun onWastePileTap(){
        GameModel.onWastePileTap()
        view?.update()
    }

    fun onFoundationPileTap(foundationIndex: Int){
        GameModel.onFoundationPileTap(foundationIndex)
        view?.update()
    }

    fun onTableauPileTap(foundationIndex: Int, cardIindex: Int){
        GameModel.onTableauTap(foundationIndex, cardIindex)
        view?.update()
    }
}