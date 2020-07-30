package filtering

import io.reactivex.Observable

/***
 * filter 람다 식 조건에 만족하는 것 들만 발행.
 * ofType -> 특정 클래스만 전달하는 operator -> rx bus 만들 때 보통 사용.
 */
fun main() {
//    Observable.just(1, 1, 2, 1, 2, 3)
//            .filter { it % 2 == 1 }
//            .subscribe(::println)

    Observable.just(1, "Hello", "RxJava", 2L)
            .ofType(String::class.java) // -> 타입 캐스팅이 됌. 그럼 코틀린의 is 와 비슷 ?
            .subscribe(::println)

    //부연 설명.
    /***
     *  filter 를 사용해서 filter { it is String } 하게 되면 subscribe 에서는 Any 형 들어온다.
     *  하지만 ofType 을 사용하면 캐스팅이 되어서 subscribe에 반영.
     */
    Observable.just(1, true, "hi")
            .ofType(String::class.java)
            .subscribe {

            }
}