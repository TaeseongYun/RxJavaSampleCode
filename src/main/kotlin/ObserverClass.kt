import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import java.util.concurrent.TimeUnit

open class CustomObservable<T>(private val disposable: CompositeDisposable,
                           private val onNextAction: (T) -> Unit) : Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        disposable.add(d)
    }

    override fun onNext(t: T) {
        onNextAction(t)
    }

    override fun onError(e: Throwable) {
        //no-op
    }

}

fun main() {

    val disposable = CompositeDisposable()

    Observable.just(1)
            .subscribe({}, {})

    CustomObservable<Int>(disposable) {
        println("Custom onNext -> $it")
    }.onNext(10)

//    val replySubject = BehaviorSubject.create<Int>()
//
//    replySubject.subscribe {
//        println("RP 첫 구독 $it")
//    }
//
//    replySubject.onNext(1)
//    Thread.sleep(3000L)
//    replySubject.subscribe {
//        println("RP 둘 구독 $it")
//    }
//    replySubject.onNext(2)
//    replySubject.onNext(3)
//    Thread.sleep(3000L)
//    replySubject.subscribe {
//        println("RP 셋 구독 $it")
//    }
//    Thread.sleep(3000L)
//    replySubject.onNext(4)
}