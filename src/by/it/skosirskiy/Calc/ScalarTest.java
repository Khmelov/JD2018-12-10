package by.it.skosirskiy.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalarTest {

    @Test
    public void add() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("3+2");
        assertEquals("5.0",actualA);
    }

    @Test
    public void sub() throws CalcException {
        Parcer parcer=new Parcer();
        //тут ваши выражения
        String actualA = parcer.calc("8-6");
        assertEquals("2.0",actualA);
    }

    @Test
    public void mul() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("11*12");
        assertEquals("132.0",actualA);
    }

    @Test
    public void div() throws CalcException {
        Parcer parcer=new Parcer();
        String actualA = parcer.calc("18/4");
        assertEquals("4.5",actualA);
    }
}