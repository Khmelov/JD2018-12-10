package by.it.subach.calc_V4;


import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
//    private double value;

    private static Map<String, Var> vars=new HashMap<>();
    private static String varsFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator +
            "by" + File.separator + "it" + File.separator + "subach" + File.separator +
            "calc_V4" +File.separator + "vars.txt";


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение " + this + " на " + other + " невозможно\n");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно\n");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно\n");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно\n");
    }

    //----------------------------------------add2-------------------------------------------//

    public Var add2(Vector other) throws CalcException {
        throw new CalcException("Сложение " + this + " на " + other + " невозможно\n");
    }

    public Var add2(Scalar other) throws CalcException {
        throw new CalcException("Сложение " + this + " на " + other + " невозможно\n");
    }

    public Var add2(Matrix other) throws CalcException {
        throw new CalcException("Сложение " + this + " на " + other + " невозможно\n");
    }

//---------------------------------------sub2-----------------------------------------------//

    public Var sub2(Scalar other) throws CalcException {
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно\n");
    }

    public Var sub2(Vector other) throws CalcException {
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно\n");
    }

    public Var sub2(Matrix other) throws CalcException {
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно\n");
    }

//---------------------------------------mul2----------------------------------------------//

    public Var mul2(Scalar other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно\n");
    }

    public Var mul2(Vector other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно\n");
    }

    public Var mul2(Matrix other) throws CalcException {
        throw new CalcException("Умножение " + this + " на " + other + " невозможно\n");
    }

//---------------------------------------div2----------------------------------------------//

    public Var div2(Scalar other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно\n");
    }

    public Var div2(Vector other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }

    public Var div2(Matrix other) throws CalcException {
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }


    @Override
    public String toString() {
        return "Что-то непонятное...";
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim();
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw  new CalcException("переменная " + operand + " не определена\n");
    }

    static void saveVar(String nameVar, Var value) {
        vars.put(nameVar,value);
    }

    static void saveVarToFile(){
        try(
                BufferedWriter out =
                    new BufferedWriter(new FileWriter(varsFile, true))
        ) {
            for(Map.Entry<String, Var> entry : vars.entrySet()){
                out.write(String.format("%s=%s\n", entry.getKey(), entry.getValue()));
            }
            out.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void loadVarFromFile(){
        if(!new File(varsFile).exists())    return;

        Parcer parcer = new Parcer();
        try(
                BufferedReader reader = new BufferedReader(new FileReader(varsFile))
                ) {
            for(; ;) {
                String s = reader.readLine();
                if(s == null)       return;
                parcer.calc(s);
            }
        }catch (IOException | CalcException e){
            e.printStackTrace();
        }

    }
}
