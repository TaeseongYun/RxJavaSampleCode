package filtering

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    println("main -> ${System.currentTimeMillis()}")

    val observable = Observable.interval(0, 100, TimeUnit.MILLISECONDS)
            .throttleLatest(250, TimeUnit.MILLISECONDS)

    observable.subscribe {
        println("Subscribe -> ${System.currentTimeMillis()}")
        println(it)
    }

    Thread.sleep(1000)
}