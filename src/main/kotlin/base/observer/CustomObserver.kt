package base.observer

typealias BaseObserve<T> = (T) -> Unit

class CustomObserver<T> : BaseObserver<T> {
    private val observerItem = mutableListOf<BaseObserve<T>>()
    override fun observe(addObserver: BaseObserve<T>) {
        observerItem += addObserver
    }

    override fun inputData(data: T) {
        observerItem.forEach {
            it(data)
        }
    }

    override fun removeAll() {
        observerItem.clear()
    }

}

fun main() {
    val customObserver: BaseObserver<Int> by lazy { CustomObserver<Int>() }

    // observe 를 하고 있으면
    customObserver.observe {
        println("Observing item $it")
    }

    //데이터가 input이 먼저 실행되고 observe가 실행
    customObserver.inputData(10)
}