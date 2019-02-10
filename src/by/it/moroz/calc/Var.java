package by.it.moroz.calc;


public abstract class Var implements Operation {


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.getError(Errors.ADD));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.getError(Errors.SUBTRACTION));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.getError(Errors.MULTIPLICATION));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResMan.INSTANCE.getError(Errors.DEVISION));
    }

}
