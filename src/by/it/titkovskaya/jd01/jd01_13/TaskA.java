package by.it.titkovskaya.jd01.jd01_13;
/*
TaskA. В методе main класса TaskA:
 напишите в main код:
if (Math.random()>0.5)
new HashMap<String, String>(null);
else
Integer.parseInt("привет");
 программно обработайте исключения: определите и выведите в консоль
имя исключения, имя класса, номер строки класса TaskA в которой это исключение возникло.
 формат вывода name: java.lang.NullPointerException
class: by.it.вашпакет.jd01_13.TaskA
line: 8
 никаких других данных выводиться не должно.
 */
import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getMethodName().equals("main")) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    System.out.printf("name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n",
                                    name, className, lineNumber);
                    break;
                }
            }
        }
    }
}
