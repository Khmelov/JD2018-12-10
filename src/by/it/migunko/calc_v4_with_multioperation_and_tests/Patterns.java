package by.it.migunko.calc_v4_with_multioperation_and_tests;

class Patterns {

    static final String SCALAR="((-?)([0-9.])+)";
    static final String VECTOR="\\{((-?([0-9.])+),?\\s*)+}";
    static final String MATRIX="\\{((\\{((-?([0-9.])+),?\\s*)+}),?\\s*)+}";
    static final String OPERATION="(?<=[^{,*=/+-])([-+*/=])";
}
