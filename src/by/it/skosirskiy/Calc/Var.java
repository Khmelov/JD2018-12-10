package by.it.skosirskiy.Calc;

import java.io.*;
import java.util.*;

abstract class Var implements Operation {
    private static String varsFile = System.getProperty("user.dir") + "" +
            "/src/by/it/skosirskiy/Calc/" +
            "vars.txt";


    private static HashMap<String,Var> vars=  new HashMap<>();

    static void saveVar(String name, Var var){
        vars.put(name, var);

    }

    static void printvar(){
        System.out.println(vars);
    }
    static void sortvar(){
        TreeMap<String, Var> treeMap = new TreeMap<>(vars);
        System.out.println(treeMap);
    }

    static Var createVar(String operand) throws CalcException{

        operand=operand.trim().replace("\\s+","").replace(" ","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand)) return vars.get(operand);

        throw new CalcException("Невозможно создать .."+operand);

    }



    @Override
    public Var add(Var other) throws CalcException  {
        throw new CalcException("Операция сложения "+this+"+"+other+"невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+"невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+"невозможна");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+"невозможна");

    }
    static void saveVarToFile() {
        try (
                BufferedWriter out =
                        new BufferedWriter(
                                new FileWriter(varsFile, true)
                        )
        ) {
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                out.write(String.format("%s=%s\n", entry.getKey(), entry.getValue()));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    static void loadVarFromFile() {
        if (!new File(varsFile).exists()) return;
        Parcer parcer;
        parcer = new Parcer();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(varsFile)
        )) {
            for (; ; ) {
                String s = reader.readLine();
                if (s == null)
                    return;
                parcer.calc(s);
            }
        } catch (IOException | CalcException e) {
            e.printStackTrace();
        }

    }
}
