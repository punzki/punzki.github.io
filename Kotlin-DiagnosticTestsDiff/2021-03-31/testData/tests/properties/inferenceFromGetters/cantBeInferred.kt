// !WITH_NEW_INFERENCE
// NI_EXPECTED_FILE
val x get() = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>foo<!>()
val y get() = <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>bar<!>()

fun <E> foo(): E = null!!
fun <E> bar(): List<E> = null!!
