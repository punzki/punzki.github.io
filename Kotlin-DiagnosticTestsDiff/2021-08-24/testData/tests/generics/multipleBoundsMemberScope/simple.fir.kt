interface A {
    fun foo()
}

interface C: A
interface B: A

fun <T> test(x: T) where T : C?, T : B? {
    x?.foo()
    if (x != null) {
        x.foo()
    }
}
