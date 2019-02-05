package by.it.yarmolenka.jd02_05.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd02_05.MathCalc.Variables.Scalar;

public class ScalarAddScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2){
        return new Scalar(sc1.value+sc2.value);
    }
}
