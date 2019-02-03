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
    @Test
    public void testCTask1() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9,0}}*{{10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}, {10.0, 10.0, 10.0}}");
        assertEquals("{{60.0, 60.0, 60.0}, {150.0, 150.0, 150.0}, {240.0, 240.0, 240.0}}",actualA);
    }
    @Test
    public void testCTask2() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("{{10.0, 12.0}, {11.0, 13.0}}+{{21.0, 14.0}, {17.0, 19.0}}");
        assertEquals("{{31.0, 26.0}, {28.0, 32.0}}",actualA);
    }
    @Test
    public void testCTask3() throws CalcException {
        Parcer parcer= new Parcer();
        String actualA = parcer.calc("{{17.0, 12.0}, {21.0, 23.0}}-{{5.0, 8.0}, {7.0, 9.0}}");
        assertEquals("{{12.0, 4.0}, {14.0, 14.0}}",actualA);
    }


}