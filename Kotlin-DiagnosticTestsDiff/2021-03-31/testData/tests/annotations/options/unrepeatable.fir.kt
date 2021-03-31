annotation class unrepann(val x: Int)

annotation class ann(val y: Int)

@unrepann(1) @unrepann(2) class DoubleAnnotated

@ann(3) @ann(7) @ann(42) class TripleAnnotated

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation class annexpr

@ann(0) @ann(1) fun foo(@ann(7) @ann(2) x: Int): Int {
    @annexpr @annexpr return x
}

@unrepann(0)
@get:unrepann(1)
var annotated = 1 // No errors should be here

@unrepann(0)
@property:unrepann(1)
var annotated2 = 2
