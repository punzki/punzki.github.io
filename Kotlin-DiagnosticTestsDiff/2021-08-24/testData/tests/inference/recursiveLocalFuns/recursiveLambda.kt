// FIR_IDE_IGNORE
fun foo() {
    fun bar() = {
        <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM!><!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()<!>
    }
}