package by.it.moroz.calc;

public class VarFactory {

    private Variables variables = Variables.getVariables();

    public Var createVar(String operand) throws CalcException {
        operand = operand.trim();
        if (variables.contains(operand)) return variables.getVar(operand);
        if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
        if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
        //TODO Replace on errors
        throw new CalcException(ResMan.INSTANCE.getError(Errors.UNDEFINED) + operand);
    }
}
