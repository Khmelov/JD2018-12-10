package by.it.skosirskiy.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void add() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("{4,5,6}+3");
        assertEquals("{7.0, 8.0, 9.0}",actualA);
        actualA = parcer.calc("{4,5,6}+{1,2,3}");
        assertEquals("{5.0, 7.0, 9.0}",actualA);
    }

    @Test
    public void sub() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("{4,5,6}-1");
        assertEquals("{3.0, 4.0, 5.0}",actualA);
        actualA = parcer.calc("{4,5,6}-{1,2,3}");
        assertEquals("{3.0, 3.0, 3.0}",actualA);

    }

    @Test
    public void mul() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("{4,5,6}*5");
        assertEquals("{20.0, 25.0, 30.0}",actualA);
        actualA = parcer.calc("{4,5,6}*{1,2,3}");
        assertEquals("32.0",actualA);
    }

    @Test
    public void div() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("{10,8,6}/2");
        assertEquals("{5.0, 4.0, 3.0}",actualA);
    }

}