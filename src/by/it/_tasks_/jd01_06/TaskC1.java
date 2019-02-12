package by.it._tasks_.jd01_06;

public class TaskC1 {
    public static void main(String[] args) {
        String[] strings = Poem.text.split("\n");
        int maxLength = 0;
        for (String string : strings) {
            if (string.length() > maxLength) maxLength = string.length();
        }

        for (String el :
                strings) {
            el.trim();
           // Systems.out.println(el);
        }

        for (int i = 0; i < strings.length; i++) {
           StringBuilder sb = new StringBuilder();
           int startLength = strings[i].length();
            if (strings[i].length()<maxLength){
                String[] buf = strings[i].split(" ");
                while ((startLength-(buf.length-1))<maxLength){
                    for (int j = 0; j < buf.length - 1; j++)  {
                        buf[j]+=" ";
                        startLength++;
                        if (startLength-(buf.length-1)==maxLength) break;
                    }
                }
                for (String el :
                        buf) {
                    sb.append(el);
                }
                strings[i]=sb.toString();
               // Systems.out.println(strings[i].length());

            }
            System.out.println(strings[i]);
        }
    }
}
