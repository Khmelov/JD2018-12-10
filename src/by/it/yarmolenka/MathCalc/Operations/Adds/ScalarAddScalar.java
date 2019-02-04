package by.it.yarmolenka.MathCalc.Operations.Adds;

import by.it.yarmolenka.MathCalc.Variables.*;

public class ScalarAddScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2){
        return new Scalar(sc1.value+sc2.value);
    }
}
