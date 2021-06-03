package ru.maxdexter.rx

import io.reactivex.Observable

fun main() {
    val manNames = listOf("Misha", "Dima", "Max", "Pety", "Kolya")
    val womanNames = listOf("Sveta", "Tanya", "Lena", "Masha")
    // merge(manNames, womanNames)
    // concat(manNames, womanNames)
    //amb(manNames, womanNames)
    zip(manNames, womanNames)


}

//Мержит в случайном порядке
fun merge(list1: List<String>, list2: List<String>) {
    val man = Observable.fromIterable(list1)
    val woman = Observable.fromIterable(list2)

    val merge = Observable.merge(man, woman).subscribe(
        { s -> println(s) },
        { t -> println(t.message) }
    )

}

//Мержит последовательно, сначало первый поток потом второй
fun concat(list1: List<String>, list2: List<String>) {
    val man = Observable.fromIterable(list1)
    val woman = Observable.fromIterable(list2)

    val concat = Observable.concat(man, woman).subscribe(
        { s -> println(s) },
        { t -> println(t.message) }
    )
}

//Излучает только данные из потока который первый стал их отдавать
fun amb(list1: List<String>, list2: List<String>) {
    val man = Observable.fromIterable(list1)
    val woman = Observable.fromIterable(list2)

    val amb = Observable.amb(listOf(man, woman)).subscribe(
        { s -> println(s) },
        { t -> println(t.message) }
    )
}

//объеденяет несколько элемента из разных источников
fun zip(list1: List<String>, list2: List<String>) {
    val man = Observable.fromIterable(list1)
    val woman = Observable.fromIterable(list2)

    val zip = Observable.zip(man.map { it }, woman.map { it }, ::Pair)
//    {
//        m,w -> "$m $w"
//    }
        .subscribe(
            { s -> println(s) },
            { t -> println(t.message) }
        )
}

fun combineLatest(list1: List<String>, list2: List<String>) {
    val man = Observable.fromIterable(list1)
    val woman = Observable.fromIterable(list2)
    val combineLatest = Observable.combineLatest(man.map { it }, woman.map { it }, ::Pair)
        .subscribe(
            { s -> println(s) },
            { t -> println(t.message) })
}

fun flatMap(list1: List<String>, list2: List<String>) {
    val man = Observable.fromIterable(list1)
    val woman = Observable.fromIterable(list2)
    val combineLatest = Observable.combineLatest(man.map { it }, woman.map { it }, ::Pair)
        .subscribe(
            { s -> println(s) },
            { t -> println(t.message) })
}



