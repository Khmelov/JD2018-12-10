package by.it.dziomin.calculator.interfaces;

import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.vars.Var;

public interface IDiv {
    Var div(Var other)throws CalcException;
}
