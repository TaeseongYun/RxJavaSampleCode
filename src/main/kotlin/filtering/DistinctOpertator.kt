package filtering

import io.reactivex.Observable


/***
 * 1. distinct -> 이미 들어온 데이터에 대해선 재 발행을 하지 않는다.
 * 2. distinctUntilChanged() -> 데이터가 변하기 전 까지 동일한 데이터는 발행하지 않는다.
 ***/

fun main() {
//    Observable.just(1, 1, 2, 3, 2, 1)
//            .distinct()
//            .subscribe(::println)
    Observable.just(1, 1, 2, 1, 2, 3)
            .distinctUntilChanged()
            .subscribe(::println)
}