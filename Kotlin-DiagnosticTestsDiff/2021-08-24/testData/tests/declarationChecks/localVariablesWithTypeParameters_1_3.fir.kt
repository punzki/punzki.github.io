// !DIAGNOSTICS: -UNUSED_VARIABLE
// !LANGUAGE: -ProhibitTypeParametersForLocalVariables

import kotlin.reflect.KProperty

fun test() {
    val <T> a0 = 0
    val <T : __UNRESOLVED__> a1 = ""
    val <T : String> a2 = 0
    <!WRONG_MODIFIER_TARGET!>const<!> val <T> a3 = 0
    <!INAPPLICABLE_LATEINIT_MODIFIER!>lateinit<!> val <T> a4 = 0
    val <T> a5 by Delegate<Int>()
    val <T> a6 by <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE!>Delegate<<!UNRESOLVED_REFERENCE!>T<!>>()<!>
}

class Delegate<F> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = ""
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {}
}
