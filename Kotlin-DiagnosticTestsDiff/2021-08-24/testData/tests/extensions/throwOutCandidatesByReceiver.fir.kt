package bar


// should be thrown away

fun <R> List<R>.a() {}

fun test1(i: Int?) {
    1.<!INAPPLICABLE_CANDIDATE!>a<!>()
    i.<!INAPPLICABLE_CANDIDATE!>a<!>()
}

fun <R> test2(c: Collection<R>) {
    c.<!INAPPLICABLE_CANDIDATE!>a<!>()
}

fun Int.foo() {}

fun test3(s: String?) {
    "".<!INAPPLICABLE_CANDIDATE!>foo<!>()
    s.<!INAPPLICABLE_CANDIDATE!>foo<!>()
    "".foo(<!TOO_MANY_ARGUMENTS!>1<!>)
    s.foo(<!TOO_MANY_ARGUMENTS!>"a"<!>)
}

interface A
fun <T: A> T.c() {}

fun test4() {
    1.<!INAPPLICABLE_CANDIDATE!>c<!>()
}


// should be an error on receiver, shouldn't be thrown away

fun test5() {
    1.(<!FUNCTION_EXPECTED!>fun String.()=1<!>)()
}

fun <R: Any> R?.sure() : R = this!!

fun <T> test6(l: List<T>?) {
    l.<!INAPPLICABLE_CANDIDATE!>sure<!><T>()
}


fun List<String>.b() {}

fun test7(l: List<String?>) {
    l.<!INAPPLICABLE_CANDIDATE!>b<!>()
}

fun test8(l: List<Any>?) {
    l.<!INAPPLICABLE_CANDIDATE!>b<!>()
}
