package by.it.yarmolenka.jd02_04.MathCalc.Operations.Muls;

import by.it.yarmolenka.jd02_04.MathCalc.Variables.Scalar;

public class ScalarMulScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.value*sc2.value);
    }
}
