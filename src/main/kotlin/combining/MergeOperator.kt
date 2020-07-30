package combining

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


//여러개의 옵저버블을 하나로 만들어 줌.
fun main() {
//    val observable1 = Observable.interval(0, 1000L, TimeUnit.MILLISECONDS).map { "1 : $it" }
//
//    Observable.interval(0, 750L, TimeUnit.MILLISECONDS).map { "2 : $it" }
//            .mergeWith(observable1)
//            .subscribe {
//                println(System.currentTimeMillis())
//                println(it)
//            }


//    val observable = Observable.merge(observable1, observable2)

//    observable2.subscribe {
//
//    }

//    Thread.sleep(3000)
    Observable.just(1, 2, 3, 4, 5)
            .startWith(100)
            .subscribe(::println)
}