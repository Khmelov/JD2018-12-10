package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions;

public class Patterns {

    private Patterns() {
    }

    public static final String SCALAR = "-?[0-9]+(.[0-9]+)?";
    public static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    public static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    public static final String OPERATION = "[+*/=-]";
    static final String BRACKETS = "\\([a-z0-9 */+-]+\\)";
    static final String VARIABLE = "[a-z]+";
}
