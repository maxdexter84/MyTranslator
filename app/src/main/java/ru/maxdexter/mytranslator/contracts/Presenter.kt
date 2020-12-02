package ru.maxdexter.mytranslator.contracts
//Ничего не знает ни о контексте ни о фреймворке
interface Presenter<T: AppState, V: View> {
    fun attachView(view: V)
    fun detachView(view: V)
    //Получение данных с флагом isOnline(из интернета или из базы)
    fun getData(word: String, isOnline: Boolean)
}