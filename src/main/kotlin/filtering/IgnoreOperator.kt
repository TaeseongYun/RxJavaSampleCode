package filtering

import io.reactivex.Observable


/***
 * 데이터는 받아오지 않고 성공여부만 받아오겠다 싶으면, ignoreElements를 사용. 당연 데이터는 subscribe 에서 사용할 수 없다.
 */
fun main() {
    Observable.just(1, 2, 3, 1, 2, 4, 5)
            .ignoreElements()
            .subscribe {
                println("onComplete")
            }
}