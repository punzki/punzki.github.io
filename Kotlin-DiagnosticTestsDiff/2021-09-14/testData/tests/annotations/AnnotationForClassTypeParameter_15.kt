// !LANGUAGE: -ClassTypeParameterAnnotations
@Target(AnnotationTarget.TYPE_PARAMETER)
annotation class A1

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation class A2(val some: Int = 12)

class TopLevelClass<<!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A1<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2(3)<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A1(12)<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2("Test")<!> T> {
    class InnerClass<<!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A1<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2(3)<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A1(12)<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2("Test")<!> T> {
        fun test() {
            class InFun<<!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A1<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2(3)<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A1(12)<!> <!UNSUPPORTED, WRONG_ANNOTATION_TARGET!>@A2("Test")<!> T>
        }
    }
}