package by.it.zagurskaya.calc;

//public class Var extends Object{
//  public Var(){
//     super();// контруктор предка
//    }
//}

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Var createVar(String operand) throws CalcException {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        if (vars.containsKey(operand))
            return vars.get(operand);
        throw new CalcException(LocalMessages.NOT_DEFINED_SUPPLIER.get() + operand);//notDefined
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(LocalMessages.ADDITION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//addition on impossible
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(LocalMessages.SUBTRACTION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//subtraction on impossible

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(LocalMessages.DIVISION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get());//division on impossible

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(LocalMessages.MULTIPLICATION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get()); //multiplication on impossible

    }

    @Override
    public String toString() {

        return LocalMessages.NOT_DEFINED_SUPPLIER.get();
    }//notDefined


}