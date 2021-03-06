// !JVM_TARGET: 1.8

interface A {
    <!JVM_DEFAULT_IN_DECLARATION!>@<!DEPRECATION!>JvmDefault<!><!>
    fun test() {
    }
}

interface <!JVM_DEFAULT_THROUGH_INHERITANCE!>B<!> : A {
}


open class <!JVM_DEFAULT_THROUGH_INHERITANCE!>Foo<!> : B
open class <!JVM_DEFAULT_THROUGH_INHERITANCE!>Foo2<!> : B, A

open class FooNoError : B {
    override fun test() {
    }
}
open class Foo2NoError : B, A {
    override fun test() {
    }
}

class <!JVM_DEFAULT_THROUGH_INHERITANCE!>Bar<!> : Foo()
class <!JVM_DEFAULT_THROUGH_INHERITANCE!>Bar2<!> : Foo(), A
class <!JVM_DEFAULT_THROUGH_INHERITANCE!>Bar3<!> : Foo(), B

open class BarWithJvmDefault : B {
    <!JVM_DEFAULT_NOT_IN_INTERFACE!>@<!DEPRECATION!>JvmDefault<!><!>
    override fun test() {
    }
}

class BarWithJvmDefaultSuper: BarWithJvmDefault()
