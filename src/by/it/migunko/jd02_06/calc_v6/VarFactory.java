package by.it.migunko.jd02_06.calc_v6;

public class VarFactory {
    private VarFactory(){}

    static Var createVar(String operand){
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)){
            return new Vector(operand);
        }
        return Vars.getVar(operand);
    }
}
