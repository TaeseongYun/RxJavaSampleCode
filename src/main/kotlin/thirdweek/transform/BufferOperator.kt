package thirdweek.transform

import io.reactivex.Observable

//buffer skip -> 버퍼에 담긴 것 포함에서 n개 만큼 버리고 다음 들어온 데이터 진행.
// 0, 1, 2, 3, 4, 5 size 가 2 고 skip 이 3 이면
// 버퍼에는 2개까지 차면 데이터를 emit 해주고 skip 이 3 이니까 들어온 2개 포함 총 3개를 버리고 다음 데이터를 버퍼에 담기 시작.

fun main() {
    Observable.fromIterable(0..10)
        .buffer(3, 4)
        .subscribe(::println)

    //0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

    //예상 실행결과
    //0,1 2 -> 4,5,6 -> 8,9,10
}