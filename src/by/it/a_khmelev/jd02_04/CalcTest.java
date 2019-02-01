package by.it.a_khmelev.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    private Calc calc=new Calc();

    @Test
    public void testAdd() throws Exception {
        int res = calc.sum(1, 2);
        assertEquals(3, res, 0.001);
    }

    @Test
    public void testSub() throws Exception {
        int res = calc.sub(1, 2);
        assertEquals(-1, res, 0.001);
    }

    @Test
    public void testMul() throws Exception {
        int res = calc.mul(3, 2);
        assertEquals("Ошибка умножения", 6, res);
    }

    @Test
    public void testDiv() throws Exception {
        assertEquals("Ошибка деления", 2, calc.div(8, 4),1e-10);
        assertEquals("Ошибка деления", 2, calc.div(9, 4),1e-10);
    }

}