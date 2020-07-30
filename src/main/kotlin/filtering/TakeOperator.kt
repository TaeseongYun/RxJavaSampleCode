package filtering

import io.reactivex.Observable

fun main() {
    Observable.just(1,1,2,1,2,3)
            //.take(2) // 앞에서 2개를 짤라서 데이터 전달.
            .takeLast(2) // 뒤에 2개를 짤라서 데이터 전달.
            .subscribe {
                println(it)
            }
}