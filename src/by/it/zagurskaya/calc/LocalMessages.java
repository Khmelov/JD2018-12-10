package by.it.zagurskaya.calc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static by.it.zagurskaya.calc.strings.Message.*;

public class LocalMessages {

    static private final ResMan resMan = ResMan.INSTANCE;

    private static final Map<String, String> languageMap = new HashMap<String, String>(){{
       put("ru", "ru");
       put("be", "be");
       put("en", "");
    }};

    private static final Map<String, String> countryMap = new HashMap<String, String>(){{
       put("ru", "RU");
       put("be", "BY");
       put("en", "");
    }};

    static Collection<String> getSupportedLanguages() {
        return languageMap.keySet();
    }

    static public void setLocale(String language) {
        resMan.setLocale(languageMap.get(language), countryMap.get(language));
    }

//    public static String getNotDefined() {
//        return resMan.get(NOT_DEFINED);
//    }

    static final Supplier<String> NOT_DEFINED_SUPPLIER = () -> resMan.get(NOT_DEFINED);
    static final Supplier<String> ADDITION_SUPPLIER = () -> resMan.get(ADDITION);
    static final Supplier<String> SUBTRACTION_SUPPLIER = () -> resMan.get(SUBTRACTION);
    static final Supplier<String> DIVISION_SUPPLIER = () -> resMan.get(DIVISION);
    static final Supplier<String> MULTIPLICATION_SUPPLIER = () -> resMan.get(MULTIPLICATION);
    static final Supplier<String> ACTION_SUPPLIER = () -> resMan.get(ACTION);
    static final Supplier<String> IMPOSSIBLE_SUPPLIER = () -> resMan.get(IMPOSSIBLE);
    static final Supplier<String> ON_SUPPLIER = () -> resMan.get(ON);
    static final Supplier<String> NOT_REALIZED_SUPPLIER = () -> resMan.get(NOT_REALIZED);
    static final Supplier<String> ZERO_DIVIDE_SUPPLIER = () -> resMan.get(ZERO_DIVIDE);
    static final Supplier<String> ACTION_NOT_IMPOSSIBLE_SUPPLIER = () -> resMan.get(ACTION_NOT_IMPOSSIBLE);
    static final Supplier<String> UNEXPECTED_COMPLETION_OF_CALCULATIONS_SUPPLIER = () -> resMan.get(UNEXPECTED_COMPLETION_OF_CALCULATIONS);

}
