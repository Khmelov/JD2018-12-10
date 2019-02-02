package by.it.skosirskiy.Calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {

    @Test
    public void testATask1() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("A=2+5.3");
        assertEquals("7.3",actualA);
    }

    @Test
    public void testATask2() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("B=A*3.5");
        assertEquals("25.55",actualA);
}

    @Test
    public void testATask3() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("B1=B+0.11*-5");
        assertEquals("25.0",actualA);
    }

    @Test
    public void testATask4() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("B2=A/2-1");
        assertEquals("2.65",actualA);
    }

    @Test
    public void testBTask1() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("C=B+(A*2)");
        assertEquals("40.15",actualA);
    }
    @Test
    public void testBTask2() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0",actualA);
    }
    @Test
    public void testBTask3() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}",actualA);
    }



}