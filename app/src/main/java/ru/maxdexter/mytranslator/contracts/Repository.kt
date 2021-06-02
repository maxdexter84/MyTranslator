package ru.maxdexter.mytranslator.contracts
import io.reactivex.Observable
//Репозиторий это слой получения и хранения данных, который он передает интерактору
interface Repository <T>{
    fun getData(word: String): Observable<T>
}