// !API_VERSION: 1.2

val a = <!UNSIGNED_LITERAL_WITHOUT_DECLARATIONS_ON_CLASSPATH!>0u<!>
val b = <!UNSIGNED_LITERAL_WITHOUT_DECLARATIONS_ON_CLASSPATH!>1uL<!>

fun foo(u: <!UNRESOLVED_REFERENCE!>UInt<!>) {}
