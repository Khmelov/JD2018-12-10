package by.it.titkovskaya.jd01.jd01_13;

import java.util.Scanner;

/*
TaskB. В классе TaskB напишите цикл, который:
 считывает данные из консоли построчно и закрывается при вводе в консоль слова END;
 переводит каждую строку в вещественное число и выводит в консоль данное число и корень из суммы всех
ранее введенных чисел, включая введенное;
 если перевести ввод в число невозможно, то программа перехватывает полученную ошибку и показывает
сообщение в консоли сообщение, такого же формата, как в предыдущем задании
 если невозможно извлечь корень, то обработка аналогична, но тип ошибки - ArithmeticException
 */
public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        for (; ; ) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) break;
            try {
                input = input.trim().replace(" ", "").replace(",", ".");
                double number = Double.parseDouble(input);
                sum += number;
                if (sum < 0) throw new ArithmeticException();
                System.out.println(number);
                System.out.println(Math.sqrt(sum));
            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getMethodName().equals("main")) {
                        System.out.printf("name: %s\n" +
                                        "class: %s\n" +
                                        "line: %d\n",
                                e.getClass().getSimpleName(),
                                element.getClassName(),
                                element.getLineNumber());
                    }
                }
            }
        }
    }
}
/*
            else input = input.trim().replace(" ", "").replace(",", ".");
            if (input.matches("-?[0-9]+(\\.[0-9]+)?")) {
                double number = Double.parseDouble(input);
                sum+=number;
                System.out.println(number);
                System.out.println(Math.sqrt(sum));
            }
 */