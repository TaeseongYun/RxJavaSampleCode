package thirdweek

import io.reactivex.Observable
import kotlin.random.Random

//create interval timer 주로 쓰임.

fun main() {
    //subscirbe 하는 순간 블록이 실행 됌. (로직을 탄다.)
//    Observable.create<String> { emitter ->
//        emitter.onNext("Hello")
//
//        emitter.onNext("World")
//
//        //완료
//        emitter.onComplete()
//    }.subscribe { println(it) }

    //defer subscribe 하는 순간 다른 Observable source 를 받아서 처리 해야 할 때 사용.
    //ex

    val observable = Observable.defer {
        if(Random.nextBoolean()) {
            Observable.create<Int> {
                it.onNext(10)
                it.onNext(10)

                it.onComplete()
            }
        } else {
            Observable.create<Int> {
                it.onNext(10)
                it.onNext(30)

                it.onComplete()
            }
        }
    }

    observable.subscribe(::println)
}