package base.observer

interface BaseObserver<T> {
    fun observe(addObserver: (T) -> Unit)

    fun inputData(data: T)

    fun removeAll()
}