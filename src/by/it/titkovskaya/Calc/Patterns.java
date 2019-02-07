package by.it.titkovskaya.Calc;

class Patterns {

    private static final String LITERAL_VARIABLE = "-?[A-z]+[0-9]?";
    static final String SCALAR = "(-?([0-9]+)(\\.[0-9]+)*)";
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String OPERATION = "(?<=[^-+*/={,( ])[-+*/=]";
    static final String CALCULATION = "(?<=[^-+*/={, ])[-+*/]";
    static final String PRIOR_OPERATION
            = "\\((" + LITERAL_VARIABLE + "|" + SCALAR + "|" + VECTOR + "|" + MATRIX + ")"
            + OPERATION
            + "(" + LITERAL_VARIABLE + "|" + SCALAR + "|" + VECTOR + "|" + MATRIX + ")\\)";
    }
