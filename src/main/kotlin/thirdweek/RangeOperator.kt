package thirdweek

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {

    Observable.interval(1000L, TimeUnit.MILLISECONDS)
        .take(5000L)
        .subscribe(::println)

    // 3 부터 2개 까지 진행.
    Observable.range(3, 2)
        .subscribe(::println)
}