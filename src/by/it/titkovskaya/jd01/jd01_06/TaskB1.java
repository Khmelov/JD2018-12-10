package by.it.titkovskaya.jd01.jd01_06;

/*
Вывести в консоль все слова текста, начинающихся согласной и заканчивающихся гласной буквой.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        String reg = "\\b[^аеиоуыэюяёАЕИОУЫЭЮЯЁ ][а-яёА-ЯЁ]*[аеёиоуыэюяАЕЁИОУЫЭЮЯ]\\b";
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher=pattern.matcher(Poem.text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
