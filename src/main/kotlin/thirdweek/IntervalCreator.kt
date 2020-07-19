package thirdweek

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

//initial_delay 를 주면 n 초 만큼 기다린 후 진행.
const val INITIAL_DELAY = 0L

fun main() {
    Observable.interval(INITIAL_DELAY, 1000L, TimeUnit.MILLISECONDS)
        .subscribe(::println)

    Thread.sleep(3000L)
}