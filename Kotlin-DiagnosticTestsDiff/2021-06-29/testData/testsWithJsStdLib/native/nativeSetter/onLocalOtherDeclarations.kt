// !DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE -NON_TOPLEVEL_CLASS_DECLARATION, -DEPRECATION

fun foo() {
    <!NATIVE_ANNOTATIONS_ALLOWED_ONLY_ON_MEMBER_OR_EXTENSION_FUN, NATIVE_INDEXER_WRONG_PARAMETER_COUNT!>@nativeSetter
    fun toplevelFun(): Any<!> = 0

    <!WRONG_ANNOTATION_TARGET!>@nativeSetter<!>
    val toplevelVal = 0

    <!WRONG_ANNOTATION_TARGET!>@nativeSetter<!>
    class Foo {}
}
