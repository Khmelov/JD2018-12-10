package by.it.moroz.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void sum() {
        Calc calc = new Calc();
        int actualSum = calc.sum(3,4);
        assertEquals("Sum incorrect", 7, actualSum);
    }
}