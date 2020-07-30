package utiloperator

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

//delay 매개변수 초 뒤에 데이터 발행
fun main() {
    println(System.currentTimeMillis())
    Observable.just("Hello world")
            .delay(2000, TimeUnit.MILLISECONDS)
            .subscribe {
                println(System.currentTimeMillis())
                println(it)
            }

    Thread.sleep(1000)
}