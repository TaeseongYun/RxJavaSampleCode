package thirdweek.transform

import io.reactivex.Observable


//flatMap -> 병렬적으로 처리 concatMap -> 시퀸스하게 처리 앞의 데이터가 끝날 때 까지 뒤에 들어온 데이터는 기다림.

// switchMap -> 앞 데이터가 처리 중 뒤에 데이터가 들어오면 앞 데이터 처리되던게 중단.
fun main() {
//    Observable.just(1,2,3)
//        .flatMap { Observable.just("$it Hello", "$it World") }
//        .subscribe(::println)

//    Observable.fromIterable(0..3)
//        .map { "RxJava : $it" }
//        .subscribe(::println)


    // scan 첫 번째 인자는 결과값, 두 번째 인자는 Observable 에서 전달 해 준 데이터 값.
    Observable.fromIterable(0..3)
        .scan { t1: Int, t2: Int ->
            println("t1 -> ${t1}, t2 -> $t2")
            t1 + t2
        }.subscribe(::println)
}