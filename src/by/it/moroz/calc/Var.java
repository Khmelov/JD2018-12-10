package by.it.moroz.calc;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Var implements Operation {

    private static Map<String, Var> remember = new HashMap<>();
    private static String varsFile = System.getProperty("user.dir") + "" +
            "/src/by/it/moroz/calc/" + "vars.txt";

    static void saveVar(String name, Var var) {
        remember.put(name, var);
    }

    static void printVar() {
        Set<Map.Entry<String, Var>> entries = remember.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static void sortVar() {
        Map<String, Var> sorted = new TreeMap<>(remember);
        Set<Map.Entry<String, Var>> entries = sorted.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public static Var createVar(String operand) throws CalcException {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        if (remember.containsKey(operand)) return remember.get(operand);
        //TODO Replace on errors
        throw new CalcException("Переменная " + operand + " неопределена.");
    }

    public static void loadVarFromFile() {
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

    static void saveVarToFile() {
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


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " на " + other + " невозможно.");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно.");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно.");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно.");
    }

}
