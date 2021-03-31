// !DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE -UNCHECKED_CAST -UNUSED_EXPRESSION -UNREACHABLE_CODE
// !LANGUAGE: +NewInference

fun <K> materialize(): K = null as K
fun <K, T> materializeWithGenericArg(x: T): K = null as K

fun <K> id(x: K): K = null as K
fun <K> K.idFromReceiver(): K = null as K
fun <K> K.idFromReceiverWithArg(x: String): K = null as K

fun <S> select(x: S, y: S): S = x

class Foo<T> {
    fun idFromClassTypeArg(): T = null as T
    fun <K> idFromClassTypeArgWithAnotherTypeArg(): T = null as T
    fun <K> materialize(): K = null as K
}

fun test() {
    if (true) materialize() else null

    val x1: String? = if (true) materialize() else null

    val x2: String? = if (true) materializeWithGenericArg("") else null

    val x3: String? = if (true) {
        if (true) materialize() else null
    } else null

    val x4: String? = if (true) {
        select(materialize(), null)
    } else null

    val x5: String? = select(if (true) materialize() else null, null)

    val x6: String? = select(materialize(), null)

    val x7: String? = select(null.idFromReceiver(), null)

    val x8: String? = select(null.idFromReceiverWithArg(""), null)

    val foo = Foo<Nothing?>()

    val x9: String? = select(foo.materialize(), null)
    val x10: String? = select(foo.idFromClassTypeArgWithAnotherTypeArg(), null)
    val x11: String? = select(foo.idFromClassTypeArg(), null)

    foo.run {
        val x12: String? = select(materialize(), null)
        val x13: String? = select(idFromClassTypeArgWithAnotherTypeArg(), null)
        val x14: String? = select(idFromClassTypeArg(), null)
    }

    val boolean: Boolean? = true

    val x15: String? = when (boolean) {
        true -> select(materialize(), null)
            false -> select(materialize(), null)
            null -> null
    }

    val x16: String? = when (boolean) {
        true -> null
        false -> materialize()
        null -> null
    }

    val x17: String? = when (boolean) {
        true -> if (true) null else materialize()
        false -> if (true) materialize() else null
            null -> if (true) null else null
    }

    val x18: String? = try {
        materialize()
    } catch (e: Exception) {
        null
    }

    val x19: String? = if (true) materialize<Nothing?>() else null

    val x20: String? = if (true) materialize<String?>() else null

    val x21: String? = if (true) materialize() else TODO()

    val x22: String? = if (true) return else materialize()

    val x23: String? = if (true) id(null) else null

    foo1(if (true) materialize() else null)

    val x24 = id(foo1(if (true) materialize() else null))

    val x25 = select(materialize(), null).foo2()

    // TODO
    val x26 = select(materialize(), null).run { foo2() }

    val x27: () -> String? = {
        id(id(if (true) materialize() else null))
    }
}

fun foo1(x: String?) {}
fun String?.foo2() {}
