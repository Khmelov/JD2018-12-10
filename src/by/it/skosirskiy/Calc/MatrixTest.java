package by.it.skosirskiy.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void add() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("1+{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}");
        assertEquals("{{2.0, 3.0, 4.0}, {5.0, 6.0, 7.0}, {8.0, 9.0, 10.0}}",actualA);
        actualA = parcer.calc("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}+{{10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}}");
        assertEquals("{{11.0, 12.0, 13.0}, {14.0, 15.0, 16.0}, {17.0, 18.0, 19.0}}",actualA);

    }

    @Test
    public void sub() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}-1");
        assertEquals("{{0.0, 1.0, 2.0}, {3.0, 4.0, 5.0}, {6.0, 7.0, 8.0}}",actualA);
        actualA = parcer.calc("{{10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}}-{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}");
        assertEquals("{{9.0, 8.0, 7.0}, {6.0, 5.0, 4.0}, {3.0, 2.0, 1.0}}",actualA);
    }

    @Test
    public void mul() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}*{1.0, 2.0, 3.0}");
        assertEquals("{14.0, 32.0, 50.0}",actualA);
        actualA = parcer.calc("{{10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}}*{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}");
        assertEquals("{{120.0, 150.0, 180.0}, {120.0, 150.0, 180.0}, {120.0, 150.0, 180.0}}",actualA);
    }
}