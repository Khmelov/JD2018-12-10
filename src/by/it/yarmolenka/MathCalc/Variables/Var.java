package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.*;
import by.it.yarmolenka.MathCalc.Strings.MathError;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    public static Map<String, Var> list = new HashMap<>();
    private static String pathToVarsFile = GetPath.getPath(Vector.class) + "vars.txt";
    private static Translator translator = Translator.INSTANCE;

    public Var() {}

    public Var(String s){
        System.out.println("Неизвестная переменная " + s);
    }

    public static void addVar(String s, Var two) {
        list.put(s.trim(), two);
    }

    public static Var getVariable(String s) throws CalcException {
        if (list.containsKey(s))
        return list.get(s);
        else {
            Translator resMan = Translator.INSTANCE;
            throw new CalcException(resMan.get(MathError.UNKNOWN_VARIABLE), resMan);
        }
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

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(translator.get(MathError.ADD), translator);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(translator.get(MathError.SUB), translator);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(translator.get(MathError.MUL), translator);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(translator.get(MathError.DIV), translator);
    }

    public Var add2(Scalar scalar) throws CalcException {
        throw new CalcException(translator.get(MathError.ADD), translator);
    }

    public Var add2(Vector vector) throws CalcException {
        throw new CalcException(translator.get(MathError.ADD), translator);
    }

    public Var add2(Matrix matrix) throws CalcException {
        throw new CalcException(translator.get(MathError.ADD), translator);
    }

    public Var sub2(Scalar scalar) throws CalcException {
        throw new CalcException(translator.get(MathError.SUB), translator);
    }

    public Var sub2(Vector vector) throws CalcException {
        throw new CalcException(translator.get(MathError.SUB), translator);
    }

    public Var sub2(Matrix matrix) throws CalcException {
        throw new CalcException(translator.get(MathError.SUB), translator);
    }

    public Var mul2(Scalar scalar) throws CalcException {
        throw new CalcException(translator.get(MathError.MUL), translator);
    }

    public Var mul2(Vector vector) throws CalcException {
        throw new CalcException(translator.get(MathError.MUL), translator);
    }

    public Var mul2(Matrix matrix) throws CalcException {
        throw new CalcException(translator.get(MathError.MUL), translator);
    }

    public Var div2(Scalar scalar) throws CalcException {
        throw new CalcException(translator.get(MathError.DIV), translator);
    }

    public Var div2(Vector vector) throws CalcException {
        throw new CalcException(translator.get(MathError.DIV), translator);
    }

    public Var div2(Matrix matrix) throws CalcException {
        throw new CalcException(translator.get(MathError.DIV), translator);
    }
}
