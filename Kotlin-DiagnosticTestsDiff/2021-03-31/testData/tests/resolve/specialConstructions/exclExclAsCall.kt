// !WITH_NEW_INFERENCE
package a

interface A

fun <T>id(t: T): T = t
fun doList(l: List<Int>) = l
fun doInt(i: Int) = i

fun <T> strangeNullableList(f: (T) -> Unit): List<T>? = throw Exception()
fun <T: A> emptyNullableListOfA(): List<T>? = null

//-------------------------------

fun testExclExcl() {
    doList(<!TYPE_INFERENCE_UPPER_BOUND_VIOLATED{OI}!>emptyNullableListOfA<!>()!!) //should be an error here
    val l: List<Int> = <!TYPE_MISMATCH{NI}!><!TYPE_MISMATCH{NI}!>id<!>(<!TYPE_INFERENCE_UPPER_BOUND_VIOLATED{OI}, TYPE_MISMATCH{NI}!>emptyNullableListOfA<!>()<!TYPE_MISMATCH{NI}!>!!<!>)<!>

    doList(strangeNullableList { doInt(it) }!!) //lambda should be analyzed (at completion phase)
}

fun testDataFlowInfoAfterExclExcl(a: Int?) {
    doInt(a!!)
    <!DEBUG_INFO_SMARTCAST!>a<!> + 1
}

fun testUnnecessaryExclExcl(a: Int) {
    doInt(a<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>) //should be warning
}
