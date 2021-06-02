package ru.maxdexter.rx

import io.reactivex.Observable

fun main() {
    println("Observable")
    observable()
    println("ObservableFilter")
    observableFilter()
}

//Observable<T>
fun observable() {
    val observable = Observable
        .just("january", "february", "march")
        .subscribe {
            println(it)
        }

}

//Observable<T>
fun observableFilter() {
    val observable = Observable
        .just("january", "february", "march")
        .filter { s -> s.length > 5 }
        .subscribe {
            println(it)
        }

}