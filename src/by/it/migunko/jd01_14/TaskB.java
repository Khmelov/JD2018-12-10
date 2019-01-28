package by.it.migunko.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TaskB {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("[а-яА-ЯёЁ]+");
        Pattern pat1 = Pattern.compile("[\\p{P}]+");
        Matcher matcher ;

        int words = 0;
        int punkts = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path("text.txt")))){

            while (br.ready()){
                String line = br.readLine();
                matcher = pat.matcher(line);
                while (matcher.find()){
                    words++;

                }

                matcher = pat1.matcher(line);
                while (matcher.find()){
                    punkts++;

                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        printToFile( String.format("words=%d, punctuation marks=%d",words,punkts),"resultTaskB.txt");
    }

    private  static  void printToFile(String s, String file){
        try( PrintWriter pw = new PrintWriter(new FileWriter(path(file)))){

            System.out.println(s);
            pw.print(s+"\n");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private  static  String path(Class<?> cl){
        String rootPrj = System.getProperty("user.dir") ;
        String path = cl.getName().replaceAll(cl.getSimpleName(),"").replace('.', File.separator.charAt(0));
        path = rootPrj + File.separator +"src" + File.separator + path;
        return  path;
    }

    private static  String path(String fileName){
        return  path(TaskB.class) + fileName;
    }
}
