package ru.maxdexter.mytranslator

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import geekbrains.ru.translator.model.data.DataModel
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.state.AppState

abstract class BaseActivity<T : DataModel> : AppCompatActivity(), View {

    protected lateinit var presenter: Presenter<T, View>

    protected abstract fun createPresenter(): Presenter<T, View>

    abstract override fun renderData(dataModel: DataModel)

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