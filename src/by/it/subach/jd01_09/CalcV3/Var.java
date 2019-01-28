package by.it.subach.jd01_09.CalcV3;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private double value;

    static Map<String, Var> vars=new HashMap<>();


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Сложение " + this + " на " + other + " невозможно");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Умножение " + this + " на " + other + " невозможно");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }

    //----------------------------------------add2-------------------------------------------//

    public Var add2(Vector other) throws CalcException{
        throw new CalcException("Сложение " + this + " на " + other + " невозможно");
    }

    public Var add2(Scalar other) throws CalcException{
        throw new CalcException("Сложение " + this + " на " + other + " невозможно");
    }

    public Var add2(Matrix other) throws CalcException{
        throw new CalcException("Сложение " + this + " на " + other + " невозможно");
    }

//---------------------------------------sub2-----------------------------------------------//

    public Var sub2(Scalar other) throws CalcException{
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно");
    }

    public Var sub2(Vector other) throws CalcException{
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно");
    }

    public Var sub2(Matrix other) throws CalcException{
        throw new CalcException("Вычитание " + this + " на " + other + " невозможно");
    }

//---------------------------------------mul2----------------------------------------------//

    public Var mul2(Scalar other) throws CalcException{
        throw new CalcException("Умножение " + this + " на " + other + " невозможно");
    }

    public Var mul2(Vector other) throws CalcException{
        throw new CalcException("Умножение " + this + " на " + other + " невозможно");
    }

    public Var mul2(Matrix other) throws CalcException{
        throw new CalcException("Умножение " + this + " на " + other + " невозможно");
    }

//---------------------------------------div2----------------------------------------------//

    public Var div2(Scalar other) throws CalcException{
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }

    public Var div2(Vector other) throws CalcException{
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }

    public Var div2(Matrix other) throws CalcException{
        throw new CalcException("Деление " + this + " на " + other + " невозможно");
    }


    @Override
    public String toString() {
        return "Что-то непонятное...";
    }

    static Var createVar(String operand) throws CalcException{
        operand = operand.trim();
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw  new CalcException("переменная " + operand + " не определена");
    }

    static void saveVar(String nameVar, Var value) {
        vars.put(nameVar,value);
    }


}
