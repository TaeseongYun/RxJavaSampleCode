package thirdweek

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    println("start:\t\t ${System.currentTimeMillis()}")


    //n초 뒤에 실행.
    Observable.timer(2000, TimeUnit.MILLISECONDS)
        .subscribe { println("start:\t\t ${System.currentTimeMillis()}") }

    Thread.sleep(3000)
}