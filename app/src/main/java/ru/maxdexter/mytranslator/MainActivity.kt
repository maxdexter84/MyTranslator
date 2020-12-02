package ru.maxdexter.mytranslator

import android.os.Bundle
import ru.maxdexter.mytranslator.adapter.MainAdapter
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.state.AppState

class MainActivity : BaseActivity<AppState>() {

    private var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun createPresenter(): Presenter<AppState, View> {
        return MainPresenterImpl()
    }

    override fun renderData(appState: AppState) {
        TODO("Not yet implemented")
    }
}