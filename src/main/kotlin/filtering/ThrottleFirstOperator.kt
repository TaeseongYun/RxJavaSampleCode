package filtering

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    println("Main fun ${System.currentTimeMillis()}")

    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
            .throttleFirst(250, TimeUnit.MILLISECONDS)

    observable.subscribe {
        println(System.currentTimeMillis())
        println(it)
    }

    Thread.sleep(1000)
}