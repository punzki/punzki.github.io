// !LANGUAGE: +ProperCheckAnnotationsTargetInTypeUsePositions -ClassTypeParameterAnnotations

annotation class A1
annotation class A2(val some: Int = 12)

@Target(AnnotationTarget.TYPE)
annotation class TA1

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation class TA2(val some: Int = 12)

class TopLevelClass<<!WRONG_ANNOTATION_TARGET!>@A1<!> <!WRONG_ANNOTATION_TARGET!>@A2(3)<!> <!WRONG_ANNOTATION_TARGET!>@A2<!> <!WRONG_ANNOTATION_TARGET!>@A1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> <!WRONG_ANNOTATION_TARGET!>@A2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>)<!> T> {
    class InnerClass<<!WRONG_ANNOTATION_TARGET!>@A1<!> <!WRONG_ANNOTATION_TARGET!>@A2(3)<!> <!WRONG_ANNOTATION_TARGET!>@A2<!> <!WRONG_ANNOTATION_TARGET!>@A1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> <!WRONG_ANNOTATION_TARGET!>@A2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>)<!> T> {
        fun test() {
            class InFun<<!WRONG_ANNOTATION_TARGET!>@A1<!> <!WRONG_ANNOTATION_TARGET!>@A2(3)<!> <!WRONG_ANNOTATION_TARGET!>@A2<!> <!WRONG_ANNOTATION_TARGET!>@A1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> <!WRONG_ANNOTATION_TARGET!>@A2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>)<!> T>
        }
    }
}

class TTopLevelClass<<!WRONG_ANNOTATION_TARGET!>@TA1<!> @TA2(3) @TA2 <!WRONG_ANNOTATION_TARGET!>@TA1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> @TA2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>) T> {
    class TInnerClass<<!WRONG_ANNOTATION_TARGET!>@TA1<!> @TA2(3) @TA2 <!WRONG_ANNOTATION_TARGET!>@TA1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> @TA2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>) T> {
        fun test() {
            class TInFun<<!WRONG_ANNOTATION_TARGET!>@TA1<!> @TA2(3) @TA2 <!WRONG_ANNOTATION_TARGET!>@TA1(<!TOO_MANY_ARGUMENTS!>12<!>)<!> @TA2(<!ARGUMENT_TYPE_MISMATCH!>"Test"<!>) T>
        }
    }
}