package ru.maxdexter.mytranslator.contracts
import io.reactivex.Observable
//источник данных для репозитория
interface DataSource<T> {
    fun getData(word: String): Observable<T>
}