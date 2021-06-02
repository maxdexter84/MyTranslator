package ru.maxdexter.mytranslator.contracts

import ru.maxdexter.mytranslator.model.DataState

//Ничего не знает ни о контексте ни о фреймворке
interface Presenter<T: DataState, V: View> {
    fun attachView(view: V)
    fun detachView(view: V)
    //Получение данных с флагом isOnline(из интернета или из базы)
    fun getData(word: String, isOnline: Boolean)
}