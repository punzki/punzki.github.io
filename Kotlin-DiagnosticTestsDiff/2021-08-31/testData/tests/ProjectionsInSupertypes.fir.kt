interface A<T> {}
interface B<T> {}
interface C<T> {}
interface D<T> {}

interface Test : A<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>in<!> Int>, B<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>out<!> Int>, C<<!PROJECTION_IN_IMMEDIATE_ARGUMENT_TO_SUPERTYPE!>*<!>>??<!NULLABLE_SUPERTYPE!>?<!>, D<Int> {}
