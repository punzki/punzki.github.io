// !WITH_NEW_INFERENCE

fun create(): Map<String, String> = null!!

operator fun <K, V> Map<K, V>.iterator(): Iterator<Map.Entry<K, V>> = null!!

operator fun <K, V> Map.Entry<K, V>.component1() = key

operator fun <K, V> Map.Entry<K, V>.component2() = value

class MyClass {
    private var m: Map<String, String>? = null
    fun foo(): Int {
        var res = 0
        m = create()
        // See KT-7428
        for ((k, v) in <!SMARTCAST_IMPOSSIBLE!>m<!>)
            res += (<!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE{NI}!>k<!>.<!DEBUG_INFO_MISSING_UNRESOLVED{NI}!>length<!> <!DEBUG_INFO_MISSING_UNRESOLVED{NI}!>+<!> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE{NI}!>v<!>.<!DEBUG_INFO_MISSING_UNRESOLVED{NI}!>length<!>)
        return res
    }
}