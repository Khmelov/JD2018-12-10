package by.it.zagurskaya.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalkTest {
    private Calk calc = new Calk();

    @Test
    public void testSum() throws Exception {
        int actualSumm = calc.sum(3, 4);
        assertEquals(7, actualSumm, 0x1.0624dd2f1a9fcp-10);
    }

    @Test
    public void testSub() throws Exception {
        int rez = calc.sub(3, 2);
        assertEquals(1, rez, 0x1.0624dd2f1a9fcp-10);
    }
    @Test
    public void testMult() throws Exception {
        int rez = calc.mult(3, 2);
        assertEquals(6, rez, 0x1.0624dd2f1a9fcp-10);
    }
    @Test
    public void testDiv() throws Exception {
        double rez = calc.div(4, 2);
        assertEquals("Ошибка деления", 2, calc.div(4, 2),1e-10);
        assertEquals("Ошибка деления", 2, calc.div(4, 2),1e-10);
    }
}