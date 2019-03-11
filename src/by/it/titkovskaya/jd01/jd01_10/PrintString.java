package by.it.titkovskaya.jd01.jd01_10;
/*
TaskB2. Напишите программу PrintString, которая выводит на консоль только имена (без
модификаторов и сигнатур) всех нестатических (т.е. экземплярных) методов стандартного
класса String.
 */
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Method[] methods = String.class.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers))
                System.out.println(name);
        }
    }
}
