package by.it.lyakhova.jd01_15;
// this

import java.io.*;


public class TaskB {
    // this is comment
    /*
    this is also comment
     */



    private static String getPath(Class<?> clazz, String filename) {
        String path = clazz.getName();
        path = path.replace(clazz.getSimpleName(), "");
        path = path.replace(".", File.separator);
        path = System.getProperty("user.dir")
                + File.separator + "src" + File.separator + path;
        return path + filename;
    }
    public static void main(String[] args) {

        String filename = getPath(TaskB.class, "TaskB.java");

        StringBuilder programText = readTxt(filename);
        System.out.println(programText);
        printToFile(programText);


    }

    /**
     * javadoc comment
     * @param filename - path
     * @return textP
     */

    private static StringBuilder readTxt(String filename) {
        StringBuilder textP = new StringBuilder();

        try (BufferedReader in =
                     new BufferedReader(
                             new FileReader(filename)
                     )
        ) {

            int b;
            while ((b = in.read())!=-1){
                if ((char) b == '/'){
                    b = in.read();
                    if ((char) b == '/'){
                        while (((char) b) != '\n') {b = in.read();}
                    }
                    else if((char) b == '*'){
                        while (true) {
                            if (((char) b) != '/') b = in.read();
                            else {
                                b = in.read();
                                break;
                            }
                        }
                    }
                    else textP.append('/');
                }
                textP.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textP;
    }

    private static void printToFile(StringBuilder list) {
        String txtOut = getPath(TaskB.class, "TaskB.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(txtOut))) {
            pw.printf(String.valueOf(list));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
