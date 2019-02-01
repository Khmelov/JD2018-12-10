package by.it.a_khmelev.calc_v4_with_multioperation_and_tests;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {
    @Test
    public void a() throws Exception {
        Parcer parcer=new Parcer();
        //тут ваши выражения
        String actualA = parcer.calc("A=2+5.3");
        assertEquals("7.3",actualA);
    }

    @Test
    public void b() throws Exception {
        Parcer parcer=new Parcer();
        //тут ваши выражения
        String actualB = parcer.calc("B=A*3.5");
        assertEquals("25.55",actualB);
    }

    // .... etc
    // .... etc
    // .... etc


}