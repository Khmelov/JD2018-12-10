package by.it.dziomin.calculator.interfaces;

import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.vars.Var;

public interface IMul {
    Var mul(Var other)throws CalcException;
}
