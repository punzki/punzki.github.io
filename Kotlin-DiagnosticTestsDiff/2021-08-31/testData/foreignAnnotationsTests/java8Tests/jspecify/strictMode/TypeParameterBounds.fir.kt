// JSPECIFY_STATE: strict

// FILE: A.java
import org.jspecify.nullness.*;

@NullMarked
public class A<T> {
    public void foo(@NullnessUnspecified T t) {}
    public <E> void bar(E e) {}
}

// FILE: B.java
import org.jspecify.nullness.*;
@NullMarked
public class B<T> {
    public void foo(T t) {}
    public <E> void bar(E e) {}
}

// FILE: Test.java
public class Test {}

// FILE: main.kt
fun <T : Test> main(a1: A<Any?>, a2: A<Test>, b1: B<Any?>, b2: B<Test>, x: T): Unit {
    a1.foo(null)
    a1.bar<T?>(null)
    a1.bar<T>(x)

    a2.foo(null)
    a2.bar<T?>(null)
    a2.bar<T>(x)

    // jspecify_nullness_mismatch
    b1.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>)
    b1.bar<T?>(null)
    b1.bar<T>(x)

    // jspecify_nullness_mismatch
    b2.foo(<!NULL_FOR_NONNULL_TYPE!>null<!>)
    b2.bar<T?>(null)
    b2.bar<T>(x)
}