// !WITH_NEW_INFERENCE
fun test() {
  if (<!UNRESOLVED_REFERENCE!>x<!> <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE{OI}, DEBUG_INFO_MISSING_UNRESOLVED{NI}!>><!> 0) {

  }
}