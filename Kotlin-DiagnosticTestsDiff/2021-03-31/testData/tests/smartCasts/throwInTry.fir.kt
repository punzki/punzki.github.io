// !DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_EXPRESSION

fun throwInTry_valueInCatch_smartcastAfterTryCatch() {
    val s = try {
        throw AssertionError()
    } catch(e: Throwable) {
        "OK"
    }
    s.length
}

fun throwInTry_valueInFinally_noSmartcastAfterTryCatchFinally() {
    val s = try {
        throw AssertionError()
    } catch(e: Throwable) {
    } finally {
        "not enough"
    }
    s.<!UNRESOLVED_REFERENCE!>length<!>
}

fun throwInTry_valueInCatchAndFinally_smartcastAfterTryCatchFinally() {
    val s = try {
        throw AssertionError()
    } catch(e: Throwable) {
        "OK"
    } finally {
        "really"
    }
    s.length
}

interface A
interface B : A

fun takeB(b: B) {}

fun conditionalThrowInTry_smartcastInTry(a: A) {
    try {
        if (a !is B) {
            throw AssertionError()
        }
        takeB(a)
    } catch (e: Throwable) {}
}

fun conditionalThrowInTry_noSmartcastAfterTryCatch(a: A) {
    try {
        if (a !is B) {
            throw AssertionError()
        }
    } catch (e: Throwable) {}
    <!INAPPLICABLE_CANDIDATE!>takeB<!>(a)
}

fun conditionalThrowInTry_rethrow_smartcastAfterTryCatch(a: A) {
    try {
        if (a !is B) {
            throw AssertionError()
        }
    } catch (e: Throwable) {
        throw e
    }
    <!INAPPLICABLE_CANDIDATE!>takeB<!>(a)
}

fun conditionalThrowInTry_rethrow_smartcastAfterTryCatchFinally(a: A) {
    try {
        if (a !is B) {
            throw AssertionError()
        }
    } catch (e: Throwable) {
        throw e
    } finally {}
    <!INAPPLICABLE_CANDIDATE!>takeB<!>(a)
}

fun conditionalThrowInTry_rethrow_noSmartcastInFinally(a: A) {
    try {
        if (a !is B) {
            throw AssertionError()
        }
    } catch (e: Throwable) {
        throw e
    } finally {
        <!INAPPLICABLE_CANDIDATE!>takeB<!>(a)
    }
}