package by.it.zagurskaya.calc;

//public class Var extends Object{
//  public Var(){
//     super();// контруктор предка
//    }
//}

abstract class Var implements Operation {


    @Override
    public Var add(Var other) throws CalcException {
        String message = LocalMessages.ADDITION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        throw new CalcException(message);//addition on impossible
    }

    @Override
    public Var sub(Var other) throws CalcException {
        String message = LocalMessages.SUBTRACTION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        throw new CalcException(message);//subtraction on impossible

    }

    @Override
    public Var div(Var other) throws CalcException {
        String message = LocalMessages.DIVISION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        throw new CalcException(message);//division on impossible

    }

    @Override
    public Var mul(Var other) throws CalcException {
        String message = LocalMessages.MULTIPLICATION_SUPPLIER.get() + this + LocalMessages.ON_SUPPLIER.get() + other + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
        throw new CalcException(message); //multiplication on impossible

    }

    @Override
    public String toString() {

        return LocalMessages.NOT_DEFINED_SUPPLIER.get();
    }//notDefined


}