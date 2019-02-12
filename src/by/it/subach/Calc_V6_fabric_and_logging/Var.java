package by.it.subach.Calc_V6_fabric_and_logging;


import by.it.subach.Calc_V6_fabric_and_logging.localization.Message;
import by.it.subach.Calc_V6_fabric_and_logging.localization.TranslateManager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
//    private double value;

    private static Map<String, Var> vars=new HashMap<>();
    private static String varsFile = System.getProperty("user.dir")+ File.separator + "src" + File.separator +
            "by" + File.separator + "it" + File.separator + "subach" + File.separator +
            "calc_V4" +File.separator + "vars.txt";

    private TranslateManager tm = TranslateManager.INSTANCE;

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(tm.get(Message.ADDITION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE +"\n"));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(tm.get(Message.SUBSTRATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(tm.get(Message.MULTIPLICATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(tm.get(Message.DIVIDE) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    //----------------------------------------add2-------------------------------------------//

    public Var add2(Vector other) throws CalcException {
        throw new CalcException(tm.get(Message.ADDITION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE +"\n"));
    }

    public Var add2(Scalar other) throws CalcException {
        throw new CalcException(tm.get(Message.ADDITION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE +"\n"));
    }

    public Var add2(Matrix other) throws CalcException {
        throw new CalcException(tm.get(Message.ADDITION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE +"\n"));
    }

//---------------------------------------sub2-----------------------------------------------//

    public Var sub2(Scalar other) throws CalcException {
        throw new CalcException(tm.get(Message.SUBSTRATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    public Var sub2(Vector other) throws CalcException {
        throw new CalcException(tm.get(Message.SUBSTRATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    public Var sub2(Matrix other) throws CalcException {
        throw new CalcException(tm.get(Message.SUBSTRATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

//---------------------------------------mul2----------------------------------------------//

    public Var mul2(Scalar other) throws CalcException {
        throw new CalcException(tm.get(Message.MULTIPLICATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    public Var mul2(Vector other) throws CalcException {
        throw new CalcException(tm.get(Message.MULTIPLICATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    public Var mul2(Matrix other) throws CalcException {
        throw new CalcException(tm.get(Message.MULTIPLICATION) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

//---------------------------------------div2----------------------------------------------//

    public Var div2(Scalar other) throws CalcException {
        throw new CalcException(tm.get(Message.DIVIDE) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    public Var div2(Vector other) throws CalcException {
        throw new CalcException(tm.get(Message.DIVIDE) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }

    public Var div2(Matrix other) throws CalcException {
        throw new CalcException(tm.get(Message.DIVIDE) + " " + this + " " + tm.get(Message.BY) + " " + other + " "
                + tm.get(Message.IMPOSSIBLE + "\n"));
    }


    @Override
    public String toString() {
        return tm.get(Message.WRONG);
    }

    static Var createVar(String operand) throws CalcException {
        TranslateManager tm = TranslateManager.INSTANCE;
        operand = operand.trim();
        if(operand.matches(Patterns.SCALAR))
            return VarCreator.createScalar(operand);
        else if(operand.matches(Patterns.VECTOR))
            return VarCreator.createVector(operand);
        else if(operand.matches(Patterns.MATRIX))
            return VarCreator.createMatrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw  new CalcException(tm.get(Message.VARIABLE) + " " + operand + " " + tm.get(Message.NOT_DEFINED));
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
