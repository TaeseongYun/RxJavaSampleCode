package utiloperator

import io.reactivex.Observable

fun main() {
    Observable.just("Hello", "World")
            .doOnComplete { println("do On Complete") }
            .doOnDispose { println("doOnDispose") }
            .doOnSubscribe { println("do On Subscribe") }
            .doOnError { println("do On Error") }
            //각각 의 아이템이 만들어질 때
            .doOnEach { println("do On Each") }
            .doFinally { println("do Finally") }
            //전달 될 때
            .doOnNext { println("do On Next") }
            .doOnTerminate { println("do On Terminate") }

            //스트림 종료
            .doAfterTerminate { println("do After Terminate") }
            //데이터가 발행 된 후
            .doAfterNext { println("do After next") }
            .subscribe {
                println("- $it")
            }
}