package by.it.moroz.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Variables {

    private static Variables instance;
    private Map<String, Var> remember = new HashMap<>();
    private static String varsFile ;

    private Variables(){
        varsFile= System.getProperty("user.dir") + "" +
                "/src/by/it/moroz/calc/" + "vars.txt";
    }

    public static Variables getVariables() {
        if(instance==null){
            synchronized (Variables.class){
                if (instance==null)
                    instance = new Variables();
            }
        }
        return instance;
    }

    Var getVar (String operand){
        return remember.get(operand);
    }

    boolean contains (String operand){
        return remember.containsKey(operand);
    }

    void saveVar(String name, Var var) {
        remember.put(name, var);
    }

    void printVar() {
        Set<Map.Entry<String, Var>> entries = remember.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    void sortVar() {
        Map<String, Var> sorted = new TreeMap<>(remember);
        Set<Map.Entry<String, Var>> entries = sorted.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    void loadVarFromFile() {
        if (!new File(varsFile).exists()) return;

        Parser parser = new Parser();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(varsFile)
        )) {
            for (; ; ) {
                String s = reader.readLine();
                if (s == null)
                    return;
                parser.calc(s);
            }
        } catch (IOException | CalcException e) {
            e.printStackTrace();
        }
    }

    void saveVarToFile() {
        try (
                BufferedWriter out =
                        new BufferedWriter(
                                new FileWriter(varsFile, true)
                        )
        ) {
            for (Map.Entry<String, Var> entry : remember.entrySet()) {
                out.write(String.format("%s=%s\n", entry.getKey(), entry.getValue()));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
