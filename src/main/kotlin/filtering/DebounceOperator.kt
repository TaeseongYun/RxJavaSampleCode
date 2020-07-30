package filtering

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/***
 *        2020 - 07 - 26(일) 4주차
 ***/

fun main() {
    //데이터는 300 후 한번 씩 호출
    Observable.interval(300, TimeUnit.MILLISECONDS)
            //200초 동안 안들어오면 데이터 발행.
            .debounce(200, TimeUnit.MILLISECONDS)
            .subscribe(::println)

    Thread.sleep(1500)
}