package by.it.subach.calc_V5;

class Patterns {

    private Patterns(){

    }

    static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR = "\\{(" + SCALAR + ",?\\s?)+}";
    static final String MATRIX = "\\{(" + VECTOR + ",?\\s?)+}";
    static final String OPERATION = "(?<=[^-+*/={, ])[-+*/=]";
    static final String LOCALIZATION_RU = "ru";
    static final String LOCALIZATION_BY = "be";
    static final String LOCALIZATION_EN = "en";


}
