// !WITH_NEW_INFERENCE
// !DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty

val c: Int by <!DELEGATE_SPECIAL_FUNCTION_NONE_APPLICABLE{NI}, DELEGATE_SPECIAL_FUNCTION_RETURN_TYPE_MISMATCH{OI}!>Delegate()<!>

class Delegate {
  operator fun getValue(t: Any?, p: KProperty<*>): String {
    return ""
  }
}
