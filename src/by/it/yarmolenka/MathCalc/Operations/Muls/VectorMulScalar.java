package by.it.yarmolenka.MathCalc.Operations.Muls;

import by.it.yarmolenka.MathCalc.Variables.*;

import java.util.Arrays;

public class VectorMulScalar {
    public static Vector vectorScalar(Vector vec, Scalar sc) {
        double[] res = Arrays.copyOf(vec.value, vec.value.length);
        for (int i = 0; i < res.length; i++) res[i] *= sc.value;
        return new Vector(res);
    }
}
