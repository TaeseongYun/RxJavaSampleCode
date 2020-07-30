package utiloperator

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

//subscribeOn 첫 Compostable 이 어떤 스케줄러 에서 돌릴건지.

//timeout 일정시간동안 데이터를 전달하지 못하면 TimeoutException 을 호출.

fun main() {
    Observable.just("Hello", "World")
            .delay(4000L, TimeUnit.MILLISECONDS)
            //timeout 에서 세 번째 인자를 주지 않으면 subscribe onError 를 타게 된다.
            .timeout(3000L, TimeUnit.MILLISECONDS, Observable.just("Hello", "RxJava"))
            .subscribe({
                println(it)
            }, {
                it.printStackTrace()
            })

    Thread.sleep(4000)
}