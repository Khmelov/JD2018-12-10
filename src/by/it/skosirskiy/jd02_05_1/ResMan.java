package by.it.skosirskiy.jd02_05_1;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResMan {

    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "by\\it\\skosirskiy\\jd02_05_02\\str";
    private ResMan(){
        resourceBundle=ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }
    public void changeResource (Locale locale){
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }
    public String getString (String key){
        return resourceBundle.getString(key);
    }
}
