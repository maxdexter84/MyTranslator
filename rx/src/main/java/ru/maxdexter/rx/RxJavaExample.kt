package ru.maxdexter.rx

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

val disposable = CompositeDisposable()
fun main() {
//    println("Observable")
//    observable()
//    println("Filter")
//    filter()
//
//    observableFromArray()
//
//    createOnSubscribe()
//
//    range()

    // interval()
    // map()
   // repeat()
    catchError()
}

//Observable<T>
fun observable() {
    val observable = Observable
        .just("january", "february", "march")
        .subscribe {
            println(it)
        }
    disposable.add(observable)

}

//Observable<T>
fun filter() {
    val observable = Observable
        .just("january", "february", "march")
        .filter { s -> s.length > 6 }
        .subscribe {
            println(it)
        }
    disposable.add(observable)

}

fun repeat() {
    val observable = Observable
        .just("january", "february", "march")
        .repeat(2)
        .subscribe {
            println(it)
        }
    disposable.add(observable)

}

fun map() {
    val observable = Observable
        .just("january", "february", "march")
        .filter { s -> s.length > 6 }
        .map { s -> s.length }
        .take(1)
        .subscribe {
            println(it)
        }
    disposable.add(observable)

}

@SuppressLint("CheckResult")
fun observableFromArray() {
    Observable.fromArray("one", "two", "three", "four", "five")
        .subscribe {
            println(it)
        }
}

@SuppressLint("CheckResult")
fun createOnSubscribe() {
    val c = Observable.create<String> { emitter ->
        emitter.onNext("Hello world ")
        emitter.onNext("Hello people")
        //emitter.onError(throw Exception("some error"))
        emitter.onComplete()


    }

    c.subscribe(
        { s -> println(s) },
        { t -> println(t) },
        { println("Поток завершился") }
    )
}


fun range() {
    val range = Observable.range(15, 10)
    val d = range.subscribe {
        println(it)
    }
    disposable.add(d)
}

fun interval() {
    val interval = Observable.interval(1, TimeUnit.SECONDS)
        .subscribe {
            println(it)
        }
    Thread.sleep(5000)
    interval.dispose()
    disposable.add(interval)
}

fun catchError() {
    val digits = Observable
        .just(5, 3, 7, 7, 0, 2, 11)
        .map{i -> 25 / i} //деление на ноль
        .retry(1) // в случае ошибки повторит попытку 1 раз
       // .onErrorReturn { _ -> -1 } // в случае ошибки вернет -1 вместо вызова ошибки
        .onErrorResumeNext(Observable.just(-5,-6,-7,-8))// в случае ошибки вернет результат из другого источника
        .subscribe(
        {s -> println(s)},
        {t -> println(t.message)}
    )
    disposable.add(digits)
}

fun onDestroy() {
    disposable.dispose()
}