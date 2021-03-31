// !WITH_NEW_INFERENCE
package foo

import kotlin.reflect.KProperty

class A {
    var a5: String by <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE{NI}, DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE{NI}!><!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>MyProperty1<!>()<!>
    var b5: String by <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE{NI}, DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE{NI}!><!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER{OI}!>getMyProperty1<!>()<!>
}

fun <A, B> getMyProperty1() = MyProperty1<A, B>()

class MyProperty1<T, R> {

    operator fun getValue(thisRef: R, desc: KProperty<*>): T {
        throw Exception()
    }

    operator fun setValue(i: Int, j: Any, k: Int) {
        println("set")
    }
}

// -----------------

class B {
    var a5: String by <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE, DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE!><!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}!>MyProperty2<!>()<!>
    var b5: String by <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE, DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE!><!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER{NI}!>getMyProperty2<!>()<!>
}

fun <A, B> getMyProperty2() = MyProperty2<A, B>()

class MyProperty2<T, R> {

    operator fun getValue(thisRef: R, desc: KProperty<*>): T {
        throw Exception()
    }

    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun setValue(i: Int) {
        println("set")
    }
}

// -----------------
fun println(a: Any?) = a