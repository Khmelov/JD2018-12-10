package by.it.moroz.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;

    private final String MESSAGE="by.it.moroz.jd02_05.messages.messages";
    private final String DATE = "by.it.moroz.jd02_05.date.date";
    private Locale locale;
    private ResourceBundle Message;
    private ResourceBundle Date;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        Message=ResourceBundle.getBundle(MESSAGE,locale);
        Date = ResourceBundle.getBundle(DATE,locale);
    }

    public void setLocale(String language) {
        setLocale(new Locale(language));
    }

    public void setLocale(String language, String country) {
        setLocale(new Locale(language,country));
    }

    public String getMessage(String key){
        return Message.getString(key);
    }

    public String getDate(String key){
        return Date.getString(key);
    }
}