package by.it.skosirskiy.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VariableParcerTest {

    @Test
    public void inScalar() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("A=5");
        assertEquals("5.0",actualA);
    }
    @Test
    public void inVector() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("C={1,2,3}");
        assertEquals("{1.0, 2.0, 3.0}",actualA);
    }
    @Test
    public void inMatrix() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("E={{1,2,3},{4,5,6}}");
        assertEquals("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}",actualA);
    }
}