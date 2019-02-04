package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Var {
    private static Map<String, Var> list = new HashMap<>();
    private static String pathToVarsFile = GetPath.getPath(Vector.class) + "vars.txt";

    public Var() {}

    public Var(String s){
        System.out.println("Неизвестная переменная " + s);
    }

    public static Var createVar(String s) throws CalcException {
        s=s.trim();
        if (list.containsKey(s)) return list.get(s);
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        if (s.matches(Patterns.VECTOR)) return new Vector(s);
        if (s.matches(Patterns.SCALAR)) return new Scalar(s);
        throw new CalcException("неизвестная переменная " + s);
    }

    public static void addVar(String s, Var two) {
        list.put(s.trim(), two);
    }

    public static Var getVariable(String s) throws CalcException {
        if (list.containsKey(s))
        return list.get(s);
        else throw new CalcException("неизвестная переменная " + s);
    }

    public static void saveVarsToFile() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(
                        pathToVarsFile)
        )
        ){
            for (Map.Entry<String, Var> entry : list.entrySet()) {
                writer.write(String.format("%s=%s%n", entry.getKey(), entry.getValue()));
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadVarsFromFile() {
        if (!new File(pathToVarsFile).exists()) return;

        Parcer p = new Parcer();

       try( BufferedReader reader = new BufferedReader(
               new FileReader(
                       pathToVarsFile)
       )
       ){
           String s;
           while ((s=reader.readLine()) != null){
               p.calc(s);
           }
       } catch (IOException | CalcException e) {
           e.printStackTrace();
       }
    }

    @Override
    public String toString(){
        return "Переменная";
    }
}
