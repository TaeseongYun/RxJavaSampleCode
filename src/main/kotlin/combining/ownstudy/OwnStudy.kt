package combining.ownstudy

import io.reactivex.Observable
import io.reactivex.rxkotlin.zipWith
import java.util.concurrent.TimeUnit
import kotlin.math.pow

fun main() {
    print("구할 배수를 입력하세요 ->")
    val firstTime = readLine()

    println()
    print("초단위를 입력하세요 (밀리세컨즈) -> ")
    val timeUnitValue = readLine()

    val observable2 = Observable.fromIterable(1..firstTime!!.toInt())

    Observable.interval(1, timeUnitValue?.toLong() ?: 1, TimeUnit.MILLISECONDS)
            .zipWith(observable2) { t1: Long, t2: Int ->
                println("t1 -> $t1,,,,, t2 -> $t2 In ZipWith")
                t1.toDouble().pow(t2)
            }.scan { t1: Double, t2: Double ->
                println("t1 -> $t1,,,,, t2 -> $t2 In Scan")
                t2
            }.subscribe({
                println("result -> $it")
            }, {
                it.printStackTrace()
            })



    Thread.sleep(9000)
}