package ru.maxdexter.mytranslator.contracts

import geekbrains.ru.translator.model.data.DataModel
import ru.maxdexter.mytranslator.state.AppState

//Ничего не знает ни о контексте ни о фреймворке
interface Presenter<T: DataModel, V: View> {
    fun attachView(view: V)
    fun detachView(view: V)
    //Получение данных с флагом isOnline(из интернета или из базы)
    fun getData(word: String, isOnline: Boolean)
}