package by.it.dziomin.calculator;

public class Patterns {

    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    public static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    public static final String OPERATION = "(?<=[^+*/-])[()=+*/-]+";
}
