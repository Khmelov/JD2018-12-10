package by.it.titkovskaya.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;

    private final String RESOURSE = "by.it.titkovskaya.jd02_05.messages";
    private Locale locale;
    private ResourceBundle resourceBundle;

    ResMan(){
        locale=Locale.getDefault();
        resourceBundle=ResourceBundle.getBundle(RESOURSE,locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }

}
