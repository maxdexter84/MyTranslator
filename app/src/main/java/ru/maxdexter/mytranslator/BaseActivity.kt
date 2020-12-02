package ru.maxdexter.mytranslator

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.state.AppState

abstract class BaseActivity<T: AppState> : AppCompatActivity(), View {
    //Ссылка на презентер
    protected lateinit var presenter: Presenter<T, View>
    protected abstract fun createPresenter(): Presenter<T,View>
    abstract override fun renderData(appState: AppState)


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        presenter = createPresenter()
    }

    //Передаем ссылку на view в презентер когда view готова
    override fun onStart() {
        super.onStart()
    presenter.attachView(this)
    }
    // При пересоздании или уничтожении View удаляем ссылку, иначе в презентере
    // будет ссылка на несуществующую View
    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }


}