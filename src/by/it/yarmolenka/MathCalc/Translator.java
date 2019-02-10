package by.it.yarmolenka.MathCalc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Translator {

    INSTANCE;

    private final String RESOURCE = Translator.class.getName()
            .replace(Translator.class.getSimpleName(), "Strings.messages");
    private ResourceBundle resourceBundle;

    Translator() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        this.resourceBundle =ResourceBundle.getBundle(RESOURCE, locale);
    }

    void setLocale(String language){
        setLocale(new Locale(language));
    }

    void setLocale(String language, String country){
        setLocale(new Locale(language, country));
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }
}
