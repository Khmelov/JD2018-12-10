package by.it.moroz.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestParser {

    @Test
    public void testCalcWithScalar() throws Exception {
        Parser parser = new Parser();
        String result1 = parser.calc("A=2+5.3");
        assertEquals("Сложение выполнено неверно", "7.3", result1);
        System.out.println("Выполнено успешно А = " + result1);

        String result2 = parser.calc("B=A*3.5");
        assertEquals("Умножение выполнено неверно", "25.55", result2);
        System.out.println("Выполнено успешно B = " + result2);

        String result3 = parser.calc("B1=B/-5");
        assertEquals("Деление выполнено неверно", "-5.11", result3);
        System.out.println("Выполнено успешно B1 = " + result3);

        String result4 = parser.calc("B2=A-1");
        assertEquals("Вычитание выполнено неверно", "6.3", result4);
        System.out.println("Выполнено успешно B2 = " + result4);



    }

    @Test
    public void testCalcWithVector() throws Exception {
        Parser parser = new Parser();
        String result1 = parser.calc("C={1,4,5}+4");
        assertEquals("Сложение выполнено неверно", "{5.0, 8.0, 9.0}", result1);
        System.out.println("Выполнено успешно C = " + result1);

        String result2 = parser.calc("C1=C*{8,6,14}");
        assertEquals("Умножение выполнено неверно", "214.0", result2);
        System.out.println("Выполнено успешно B = " + result2);

        String result3 = parser.calc("C2=C/-5");
        assertEquals("Деление выполнено неверно", "{-1.0, -1.6, -1.8}", result3);
        System.out.println("Выполнено успешно B1 = " + result3);

        String result4 = parser.calc("E=C-C1");
        assertEquals("Вычитание выполнено неверно", "{-209.0, -206.0, -205.0}", result4);
        System.out.println("Выполнено успешно B2 = " + result4);

    }

    @Test
    public void testCalcWithMatrix() throws Exception {
        Parser parser = new Parser();
        String result1 = parser.calc("{{1,4,5},{45,12,16}}+4");
        assertEquals("Сложение выполнено неверно", "{{5.0, 8.0, 9.0}, {49.0, 16.0, 20.0}}", result1);
        System.out.println("Выполнено успешно " + result1);

        String result2 = parser.calc("{{8,6,14},{1,5,8}}*3");
        assertEquals("Умножение выполнено неверно", "{{24.0, 18.0, 42.0}, {3.0, 15.0, 24.0}}", result2);
        System.out.println("Выполнено успешно " + result2);

        String result3 = parser.calc("{{1,9,7},{7,9,4},{6,4,1}}/-5");
        assertEquals("Деление выполнено неверно", "{{-0.2, -1.8, -1.4}, " +
                                                                     "{-1.4, -1.8, -0.8}, " +
                                                                      "{-1.2, -0.8, -0.2}}", result3);
        System.out.println("Выполнено успешно " + result3);

        String result4 = parser.calc("{{-2,-8,-4},{-4,-1,-8}}--1");
        assertEquals("Вычитание выполнено неверно", "{{-1.0, -7.0, -3.0}, {-3.0, 0.0, -7.0}}", result4);
        System.out.println("Выполнено успешно B2 = " + result4);

    }
}