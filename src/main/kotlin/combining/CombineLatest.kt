package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
import kotlin.random.Random


//

//scan 과 차이점. -> scan은 발행한 데이터를 가지고 조합을 하는 func
// 입력 값 유효성 검사 때.
// combineLastest 는 각 observable 이 발행한 마지막 데이터 결과값 전송.
fun main() {
    val observable1 = Observable.interval(1000L, TimeUnit.MILLISECONDS)
    val observable2 = Observable.interval(750L, TimeUnit.MILLISECONDS).map { Random.nextInt(10) }
    val observable = Observable.combineLatest<Long, Int, String>(
            observable1,
            observable2,
            BiFunction<Long, Int, String> { t1, t2 ->
                "$t1, $t2"
            }
    )

    observable.subscribe {
        println(System.currentTimeMillis())
        println(it)
    }

    Thread.sleep(3000)
}