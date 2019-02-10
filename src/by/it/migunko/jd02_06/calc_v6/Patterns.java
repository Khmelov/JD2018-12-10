package by.it.migunko.jd02_06.calc_v6;

class Patterns {

    static final String SCALAR="((-?)([0-9.])+)";
    static final String VECTOR="\\{((-?([0-9.])+),?\\s*)+}";
    static final String MATRIX="\\{((\\{((-?([0-9.])+),?\\s*)+}),?\\s*)+}";
    static final String OPERATION="(?<=[^{,*=/+-])([-+*/=])";
}
