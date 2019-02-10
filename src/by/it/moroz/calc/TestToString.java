package by.it.moroz.calc;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class TestToString {

    @Test
    public void testToString() throws Exception {
        //Constructor scalarConstructor = Scalar.class.getDeclaredConstructor(double.class);
        System.out.print("Создание Scalar на основе числа 2.8659");
        Scalar strScalar = new Scalar("2.8659");

        //Object scalar = scalarConstructor.newInstance(2.8659);
        System.out.print(" - успешно.\nВывод через метод toString");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение", "2.8659", strScalar.toString());
        System.out.println(" - успешно. Scalar = " + strScalar);

        Constructor vectorConstructor = Vector.class.getDeclaredConstructor(double[].class);
        System.out.print("Создание Vector {2,4,16}");
        Object vector = vectorConstructor.newInstance(new Object[]{new double[]{2,4,16}});
        System.out.print(" - успешно.\nВывод через метод toString");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение", "{2.0, 4.0, 16.0}", vector.toString());
        System.out.println(" - успешно. Vector = " + vector);

        Constructor matrixConstructor = Matrix.class.getDeclaredConstructor(double[][].class);
        System.out.print("Создание Matrix {{1,5,12},{8,6,3}}");
        Object matrix = matrixConstructor.newInstance(new Object[]{new double[][]{{1,5,12},{8,6,3}}});
        System.out.print(" - успешно.\nВывод через метод toString");
        System.out.flush();
        assertEquals("Не было получено ожидаемое значение", "{{1.0, 5.0, 12.0}, {8.0, 6.0, 3.0}}", matrix.toString());
        System.out.println(" - успешно. Matrix = " + matrix);

    }
}