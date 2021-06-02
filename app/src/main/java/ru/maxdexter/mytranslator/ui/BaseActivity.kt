package ru.maxdexter.mytranslator.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.maxdexter.mytranslator.model.DataState
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View

abstract class BaseActivity<T : DataState> : AppCompatActivity(), View {

    protected lateinit var presenter: Presenter<T, View>

    protected abstract fun createPresenter(): Presenter<T, View>

    abstract override fun renderData(dataState: DataState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }
}