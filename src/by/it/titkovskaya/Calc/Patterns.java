package by.it.titkovskaya.Calc;

class Patterns {

    static final String SCALAR = "(-?([0-9]+)(\\.[0-9]+)*)";
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String OPERATION = "(?<=[^-+*/={,( ])[-+*/=]";
    static final String CALCULATION = "(?<=[^-+*/={, ])[-+*/]";
    static final String PRIOR_OPERATION
            = "\\(((-?([0-9A-z ]+)(\\.[0-9 ]+)*)|" +
            "\\{((-?([0-9A-z ]+)(\\.[0-9 ]+)*),?\\s?)+}|" +
            "\\{(\\{((-?([0-9A-z ]+)(\\.[0-9 ]+)*),?\\s?)+},?\\s?)+})" +
            "(?<=[^-+*/={,( ])[-+*/=]" +
            "((-?([0-9A-z ]+)(\\.[0-9 ]+)*)|" +
            "\\{((-?([0-9A-z ]+)(\\.[0-9 ]+)*),?\\s?)+}|" +
            "\\{(\\{((-?([0-9A-z ]+)(\\.[0-9 ]+)*),?\\s?)+},?\\s?)+})\\)";
    }
