package by.it.yarmolenka.MathCalc.Variables;

import by.it.yarmolenka.MathCalc.CalcException;
import by.it.yarmolenka.MathCalc.Patterns;
import by.it.yarmolenka.MathCalc.Strings.MathError;
import by.it.yarmolenka.MathCalc.Translator;

public class CreatorVar {
    public Var getVar(String s) throws CalcException {
        Translator translator = Translator.INSTANCE;
        s=s.trim();
        if (Var.list.containsKey(s)) return Var.list.get(s);
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        if (s.matches(Patterns.VECTOR)) return new Vector(s);
        if (s.matches(Patterns.SCALAR)) return new Scalar(s);
        throw new CalcException(translator.get(MathError.UNKNOWN_VARIABLE), translator);
    }
}
