package ru.maxdexter.mytranslator.contracts

import io.reactivex.Observable
//Бизнес логика
interface Interactor<T> {
    //Use Case: получение данных для вывода на экран
    // Используем RxJava
    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}