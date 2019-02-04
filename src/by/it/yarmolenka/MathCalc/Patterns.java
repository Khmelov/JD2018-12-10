package by.it.yarmolenka.MathCalc;

public class Patterns {

    private Patterns() {
    }

    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    public static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    public static final String OPERATION = "(?<=([A-Za-z0-9\\}\\)])( )?)([=+*/-])";
    static final String BRACKETS = "\\([A-Za-z0-9 \\.*/+-]+\\)";
    static final String VARIABLE = "[A-Za-z0-9]+";
}
