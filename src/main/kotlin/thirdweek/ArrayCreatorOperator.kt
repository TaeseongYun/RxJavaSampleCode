package thirdweek

import io.reactivex.Observable

fun main() {
    val items = arrayOf("Hello", "RxJava")


    //스프레드 연산자.
    Observable.fromArray(*items)
        .subscribe(::println)
}