package ru.maxdexter.mytranslator

import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.state.AppState

class MainPresenterImpl : Presenter<AppState, View> {
    override fun attachView(view: View) {
        TODO("Not yet implemented")
    }

    override fun detachView(view: View) {
        TODO("Not yet implemented")
    }

    override fun getData(word: String, isOnline: Boolean) {
        TODO("Not yet implemented")
    }

}
