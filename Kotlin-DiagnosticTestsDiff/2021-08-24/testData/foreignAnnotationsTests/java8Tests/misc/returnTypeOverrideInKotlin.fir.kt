// SOURCE_RETENTION_ANNOTATIONS
// FILE: Base.java
public interface Base<T> {}
// FILE: A.java
import org.checkerframework.checker.nullness.qual.*;

public class A {
    @Nullable Base<@NonNull String> foo() { return null; }
}

// FILE: a.kt
interface Derived<E> : Base<E> {}

fun bar1(): Derived<String> = null!!
fun bar2(): Derived<String?> = null!!

class B : A() {
    override fun foo(): Base<String> { return bar1(); }
}

class C1 : A() {
    override fun foo(): Derived<String> { return bar1(); }
}

class C2 : A() {
    override fun foo(): Derived<String>? { return bar1(); }
}

class C3 : A() {
    override fun foo(): Derived<String?> { return bar2(); }
}
