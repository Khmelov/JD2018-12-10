package by.it.kushnerov.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    private Vector v1= new Vector("{5,6}");
    private Vector v2= new Vector("{2,5}");
    private Scalar scal = new Scalar(5);


    @Test
    public void testAdd() throws Exception {
        String res1 = v1.add(v2).toString();
        assertEquals("Ошибка сложения двух вектров","{7.0, 11.0}", res1);

        String res2 = v1.add(scal).toString();
        assertEquals("Ошибка сложения вектора со скаляром","{7.0, 10.0}",res2);
    }

    @Test
    public void testSub() throws Exception {
        String res1 = v1.sub(v2).toString();
        assertEquals("Ошибка вычитания вектров","{3.0, 1.0}", res1);

        String res2 = v1.sub(scal).toString();
        assertEquals("Ошибка вычитания вектора со скаляром","{0.0, 1.0}",res2);
    }

    @Test
    public void testMul() throws Exception {
        String res1 = v1.mul(v2).toString();
        assertEquals("Ошибка умножения вектров","40.0", res1);

        String res2 = v1.mul(scal).toString();
        assertEquals("Ошибка умножения вектора со скаляром","{10.0, 25.0}",res2);
    }

    @Test
    public void testDiv() throws Exception {
        String res2 = v1.mul(scal).toString();
        assertEquals("Ошибка деление вектора со скаляром","{1.0, 1.2}",res2);
    }
}
