package by.it.migunko.jd02_06.calc_v6;

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

}


