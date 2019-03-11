package by.it.titkovskaya.jd01.jd01_06;

/*
Вывести через \n все предложения текста в порядке возрастания количества символов
(!) в каждом из них. В предложениях нужно сначала заменить все небуквенные символы и их
последовательности на один пробел и выполнить trim() для каждого предложения.
 */

import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String newText1 = Poem.text.replaceAll("[\\s,;:-]+|[\\s]|[.]{3}[\\s*]"," ");
        String newText = newText1.replaceAll("[.?!]+[ ]*","\n");
        Pattern pattern = Pattern.compile("\n");
        String[] sentence = pattern.split(newText);
        for (int i = 1; i < sentence.length; i++) {
            for (int j = 0; j < sentence.length; j++) {
                if (sentence[i].length()<sentence[j].length()){
                    String buffer = sentence[i];
                    sentence[i]=sentence[j];
                    sentence[j]=buffer;
                }
            }
        }
        for (String i : sentence) {
            System.out.println(i);
        }
    }
}



/*
        String reg = "\\b[а-яёА-ЯЁ ,:;\\s-]*[.?!]*";
*/