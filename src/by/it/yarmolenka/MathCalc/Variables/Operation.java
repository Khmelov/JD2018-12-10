package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.CalcException;

interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}