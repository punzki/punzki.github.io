// Issue: KT-37621
// !LANGUAGE: +NewInference

class Inv<T>
class In<in I>
class Out<out O>

inline fun <reified TB : Inv<TB>> invBound(): TB = TODO()
inline fun <reified IB : In<IB>> inBound(): IB = TODO()
inline fun <reified OB : Out<OB>> outBound(): OB = TODO()

inline fun <reified T : Inv<T>> testInv(): T {
    return try {
        invBound()
    } catch (ex: Exception) {
        throw Exception()
    }
}

inline fun <reified T : In<T>> testIn(): T {
    return try {
        inBound()
    } catch (ex: Exception) {
        throw Exception()
    }
}

// Unexpected behaviour
inline fun <reified T : Out<T>> testOut(): T {
    return try {
        <!REIFIED_TYPE_FORBIDDEN_SUBSTITUTION!>outBound<!>()
    } catch (ex: Exception) {
        throw Exception()
    }
}
