// !WITH_NEW_INFERENCE
// See KT-6271
fun foo() {
    fun fact(n: Int) = {
        if (n > 0) {
            <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!><!DEBUG_INFO_MISSING_UNRESOLVED!>fact<!>(<!DEBUG_INFO_MISSING_UNRESOLVED!>n<!> <!DEBUG_INFO_MISSING_UNRESOLVED!>-<!> 1)<!> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE{OI}, DEBUG_INFO_MISSING_UNRESOLVED{NI}!>*<!> n
        }
        else {
            1
        }
    }
}
