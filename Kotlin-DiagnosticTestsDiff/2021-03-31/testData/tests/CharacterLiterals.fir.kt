fun test(c : Char) {
  test(<!ILLEGAL_CONST_EXPRESSION!>''<!>)
  test('a')
  test(<!ILLEGAL_CONST_EXPRESSION!>'aa'<!>)
  <!INAPPLICABLE_CANDIDATE!>test<!>(<!ILLEGAL_CONST_EXPRESSION!>'a)<!>
  <!UNRESOLVED_REFERENCE!>test<!>(<!ILLEGAL_CONST_EXPRESSION!>'<!>
  <!UNRESOLVED_REFERENCE!>test<!>(0<!ILLEGAL_CONST_EXPRESSION!><!SYNTAX!><!>'<!>
  <!UNRESOLVED_REFERENCE!>test<!>('\n')
  test('\\')
  test(<!ILLEGAL_CONST_EXPRESSION!>''<!><!ILLEGAL_CONST_EXPRESSION!><!SYNTAX!><!>''<!>)
  test('\'')
  test('\"')
}