package thirdweek

import io.reactivex.Observable

fun main() {
    val observable = Observable.just("Hello", "World")
        //subscribe 가 처리 되기 전에 실행.
        //doOn ~ 해당 함수가 호출 되기 전 실행 하는 함수.
        //doAfter ~ 해당 함수가 호출 된 후 실행 되는 함수. ex) doAfterNext -> Next 가 호출 된 후. doAfterTerminator -> 옵저버블이  완료, 에러 후 진행 되는 함수
        .doOnSubscribe { println("subscribe") }
        .repeat(2)

    observable.subscribe { println(it) }

    observable.subscribe()
}