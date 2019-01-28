package by.it.dziomin.calculator.interfaces;

import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.vars.Var;

public interface IAdd {
    Var add(Var other)throws CalcException;
}
