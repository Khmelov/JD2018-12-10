package by.it.subach.jd02_05;

import by.it.subach.jd02_05.strings.Message;
import by.it.subach.jd02_05.strings.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public enum  ResMan implements Message, User {

    INSTANCE;

    private final String RESOURCE = "by.it.subach.jd02_05.messages";
    private Locale locale;
    private ResourceBundle resourceBundle;

    ResMan(){
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle(RESOURCE, locale);
    }

    public void setLocale(String language){
        setLocale(new Locale(language));
    }

    public void setLocale(String language, String country){
        setLocale(new Locale(language, country));
    }

    public String get(String key){
        return resourceBundle.getString(key);
    }



    public String  getDate(String language){
        Locale locale = new Locale(language);
        Date today = new Date();
        DateFormat dateFormat = SimpleDateFormat.getDateInstance(DateFormat.LONG, locale);
        return dateFormat.format(today);
    }

    }


