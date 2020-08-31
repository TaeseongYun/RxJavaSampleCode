package kotlin_handle_skill.chapter3.`2`.`8`

fun main() {
    fun triple(x: Int) = x * 3

    fun square(x: Int) = x * x

    fun compose(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { f(g(it)) }

    val composeFunctionResult = compose(::square, ::triple)
    println("결과값 -> ${composeFunctionResult(2)}")
}