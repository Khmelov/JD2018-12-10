package by.it.moroz.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;

    private final String ERROR="by.it.moroz.calc.errors.error";
    private final String MESSAGE = "by.it.moroz.calc.messages.message";
    private Locale locale;
    private ResourceBundle Error;
    private ResourceBundle Message;

    ResMan() {
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        Error=ResourceBundle.getBundle(ERROR,locale);
        Message=ResourceBundle.getBundle(MESSAGE, locale);
    }

    public void setLocale(String language) {
        setLocale(new Locale(language));
    }

    public void setLocale(String language, String country) {
        setLocale(new Locale(language,country));
    }

    public String getError(String key){
        return Error.getString(key);
    }

    public String getMessage(String key) {return Message.getString(key);}

}
