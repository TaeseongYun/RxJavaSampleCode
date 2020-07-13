package gugudan

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit

class RxJavaGuGuDan<T>(private val disposable: CompositeDisposable,
                       internal var onNextAction: (T) -> Unit = {}) : Observer<T>, ObservableSource<T> {
    override fun onComplete() {
        println("Done")
    }

    override fun onSubscribe(d: Disposable) {
        disposable.add(d)
    }

    override fun onNext(t: T) {
        onNextAction(t)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }

    override fun subscribe(observer: Observer<in T>) {
        observer.onSubscribe(disposable)
    }

}

fun main() {
    val disposable = CompositeDisposable()

    Observable.interval(1000L, TimeUnit.MILLISECONDS)
            .map {
//                10
                2 to it
            }
            .takeUntil {
                it.second > 9L
            }
            .subscribe(object : Observer<Pair<Int, Long>> {
                override fun onComplete() {
                    println("Complete")
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: Pair<Int, Long>) {
                    println("${t.first} * ${t.second} -> ${t.first * t.second}")
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }

            })

    Thread.sleep(10000L)
}