package by.it.skosirskiy.Calc;

import java.io.*;

 class Log {


    private static int countLineLog=0;
    private static String filename = System.getProperty("user.dir") + "" +
            "/src/by/it/skosirskiy/Calc/" +
            "log.txt";


    static void saveLogOperations(String nameVariable, String value) {
        try (
                BufferedWriter file =
                        new BufferedWriter(
                                new FileWriter(filename, true)
                        )
        ) {
            countLineLog++;
            file.write(nameVariable+" "+value+"\n");
            file.flush();
            if(countLineLog>50){deleteLineLog();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteLineLog() {
        StringBuilder sb=new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename)
        )
        ) {
            String line;
            while ((line = reader.readLine())!=null){
                sb.append(line).append("\n");
            }
            sb.replace(0, sb.indexOf("\n")+1,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter printer = new PrintWriter(new FileWriter(filename))){
            printer.print(sb);
        }
         catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void toLog(String logLine) {
        try (
                BufferedWriter out =
                        new BufferedWriter(
                                new FileWriter(filename, true)
                        )
        ) {
            countLineLog++;
            out.write(logLine+"\n");
            out.flush();
            if(countLineLog>50){deleteLineLog();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getCountLineLog() {
        if (!new File(filename).exists()) countLineLog=0;
        else {try (BufferedReader reader = new BufferedReader(
                new FileReader(filename)
        )
        ) {
            while ((reader.readLine())!=null){
                countLineLog++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}

    }
}
