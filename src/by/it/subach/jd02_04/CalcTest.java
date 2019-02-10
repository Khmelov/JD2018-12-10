package by.it.subach.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void sum(){
        Calc calc = new Calc();
        int actualSum = calc.sum(3, 4);
        assertEquals("Sum incorrect", 7, actualSum);
    }

    @Test
    public void sub() throws Exception{
        Calc calc = new Calc();
        int actualSum = calc.sub(3, 4);
        assertEquals("Sub incorrect", -1, actualSum);
    }

    @Test
    public void mul() throws Exception{
        Calc calc = new Calc();
        int actualMul = calc.mul(3, 4);

        assertEquals("Sum incorrect", 12, actualMul);
    }

    @Test
    public void div() throws Exception{
    }
}