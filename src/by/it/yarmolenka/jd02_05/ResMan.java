package by.it.yarmolenka.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResMan {

    INSTANCE;

    private final String RESOURCE = ResMan.class.getName()
            .replace(ResMan.class.getSimpleName(), "messages");
    private ResourceBundle resourceBundle;


    ResMan() {
        setLocale("en", "US");
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

    String get(String key){
        return resourceBundle.getString(key);
    }
}
