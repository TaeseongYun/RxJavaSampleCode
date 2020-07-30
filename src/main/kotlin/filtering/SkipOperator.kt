package filtering

import io.reactivex.Observable

fun main() {
    Observable.just(1, 1, 2, 1, 2, 3)
//            .skip(3)  -> 1 2 3
            .skipLast(2) // 1 1 2 1
            .subscribe {
                println(it)
            }
}