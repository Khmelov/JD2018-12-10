package by.it.migunko.calc_v4_with_multioperation_and_tests;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("ERROR: Сложение %s с %s невозможно.\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("ERROR: Вычитание %s из %s невозможно.\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("ERROR: Умножение %s на %s невозможно.\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("ERROR: Деление %s на %s невозможно.\n", this, other));
    }

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


