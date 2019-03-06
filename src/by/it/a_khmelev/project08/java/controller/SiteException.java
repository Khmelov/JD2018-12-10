package by.it.a_khmelev.project08.java.controller;

public class SiteException extends Exception{
    public SiteException() {
    }

    public SiteException(String message) {
        super(message);
    }

    public SiteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SiteException(Throwable cause) {
        super(cause);
    }
}
