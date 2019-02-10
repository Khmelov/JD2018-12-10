package by.it.zagurskaya.calc;

import java.util.HashMap;
import java.util.Map;

public class VarCreator {

    private static volatile VarCreator instance;
    private Map<String, Var> vars = new HashMap<>();

    private VarCreator() {
    }

    public static VarCreator getInstance() {
        if (instance == null) {
            synchronized (VarCreator.class) {
                if (instance == null)
                    instance = new VarCreator();
            }
        }
        return instance;
    }

    public Var create(String operand) throws CalcException {
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

    public Map<String, Var> getVars() {
        return vars;
    }

    public Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public String toString(double[] value) {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";

        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }

    public String toString(double[][] value) {
        StringBuilder out = new StringBuilder("{");
        String delimiteri = "";
        String delimiterj = "";
        for (int i = 0; i < value.length; i++) {
            out.append(delimiteri).append('{');
            delimiterj = "";
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiterj).append(value[i][j]);
                delimiterj = ", ";
            }
            out.append('}');
            delimiteri = ", ";
        }
        out.append('}');

        return out.toString();
    }
}
