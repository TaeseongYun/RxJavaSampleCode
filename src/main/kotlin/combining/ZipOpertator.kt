package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction


//순서가 중요한 operator
fun main() {
    val operator1 = Observable.just(1, 2, 3, 4, 5)
    val operator2 = Observable.just("a", "b", "c", "d")
            //zipWith 를 쓰게 되면
            .zipWith(
                    operator1,
                    // zipWith 를 부르는 객체 데이터에 따라 BiFunction의 제네릭이 변함.
                    //여기는 zipWith 를 부른 객체의 데이터가 String이기 때문에 <String ,Int, String>
                    BiFunction<String, Int, String> { t1, t2 ->
                        "$t1, $t2"
                    }
            )

    operator2.subscribe {
        println(it)
    }
//    val observable = Observable.zip(
//            operator1,
//            operator2,

    //첫 번째가 operator1 의 데이터는 int형 이기때문에 BiFunction 순서는 Int, String, String
//            BiFunction<Int, String, String> { t1, t2 ->
//                "$t1 , $t2"
//            }
//    )
//    observable.subscribe {
//        println(it)
//    }
}