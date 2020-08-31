package kotlin_handle_skill.chapter3.`2`.`8`

fun main() {
    fun square(x: Int) = x * x

    fun triple(x: Int) = x * 3

    fun <T, U, V> compose(f: (T) -> U, g: (V) -> T): (V) -> U = { f(g(it)) }


    val result = compose(::triple, ::square)

    println("결과 -> ${result(3)}")

    val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

    println("add 결과 -> ${add(2)(3)}")
}