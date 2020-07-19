package thirdweek

import io.reactivex.Observable

fun main() {
    println("System.currentTime ${System.currentTimeMillis()}")

    fun createItem(): String {
        println("System.currentTime ${System.currentTimeMillis()}")
        return "Hello Rxjava"
    }

    val observable = Observable.fromCallable { createItem() }
    Thread.sleep(1000L)


    //subscribe 하는순간 createItem() 호출.
    observable.subscribe(::println)
    Thread.sleep(1000L)
    observable.subscribe(::println)
}