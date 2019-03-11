package by.it.titkovskaya.jd01.jd01_15;
/**new java doc*/
import java.io.*;
/*
TaskB
 В программе создайте хотя бы 5 разных комментариев: 2 однострочных, 2 многострочных и 1 JavaDoc
 Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 Результат вывести на консоль и в файл с тем же местоположением и именем, но с расширением txt, а не java.
 Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”) и внутри комментария тоже.
Регулярные выражения использовать нельзя
 */
public class TaskB {

    public static void main(String[] args) {
        /*
        1) Напишем путь к исходному файлу для прочтения
        2) Укажем путь к файлу для вывода обработанного текста
         */
        String fileName = System.getProperty("user.dir") + "" + "/src/by/it/titkovskaya/jd01_15/TaskB.java";
        String fileOut = System.getProperty("user.dir") + "" + "/src/by/it/titkovskaya/jd01_15/TaskB.txt";
        StringBuilder sb = new StringBuilder();
        readFile(fileName, sb);
        System.out.println(sb.toString()); //Выведем результат на консоль и в файл
        printToFile(fileOut, sb);
    }

    private static void readFile(String fileName, StringBuilder sb) {
        int ch;
        int nextCh;
        //Осуществим чтение при помощи BufferedReader:
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                ch = reader.read();
                if (ch == '/') {
                    if ((nextCh = reader.read()) == '*') {
                        do {
                            ch = reader.read();
                        }
                        while (ch != '*');
                        ch=reader.read();
                        if (ch != '/') {
                            do {
                                ch = reader.read();
                            }
                            while (ch != '*');
                            ch=reader.read();
                            if (ch == '/'){
                                sb.append((char) (reader.read()));
                            }
                        } else sb.append((char) (reader.read()));
                    } else if (nextCh == '/') {
                        do {
                            ch = reader.read();
                        }
                        while (ch != '\n');
                        sb.append((char) ch);
                    } else sb.append((char) ch).append((char)(nextCh));
                } else {
                    sb.append((char) ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printToFile(String fileOut, StringBuilder sb) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileOut))) {
            out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
