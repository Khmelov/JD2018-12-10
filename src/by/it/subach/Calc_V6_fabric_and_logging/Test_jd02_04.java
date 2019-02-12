package by.it.subach.Calc_V6_fabric_and_logging;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {
    @Test
    public void TestA() throws Exception {
        System.out.println("Старт теста для парсера А...");
        Parcer parcer = new Parcer();
        String actualA = parcer.calc("A=2+5.3");
        assertEquals("7.3", actualA);
        String actualB = parcer.calc("B=A*3.5");
        assertEquals("25.55", actualB);
        String actualB1 = parcer.calc("B1=B+0.11*-5");
        assertEquals("25.0", actualB1);
        String actualB2 = parcer.calc("B2=A/2-1");
        assertEquals("2.65", actualB2);

    }

    @Test
    public void TestB() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Старт теста для парсера B...");
        String actualC = parcer.calc("C=B+(A*2)");
        assertEquals("40.15", actualC);
        String actualD = parcer.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", actualD);
        String actualE = parcer.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", actualE);

    }

    @Test
    public void scalarAddScalarTest() throws Exception{
        Parcer parcer = new Parcer();
        System.out.println("Сложение скаляра со скаляром...");
        String actualA = parcer.calc("A=2+3");
        assertEquals("5.0", actualA);
        String actualB= parcer.calc("B=2+-3");
        assertEquals("-1.0", actualB);
    }

    @Test
    public void scalarSubScalarTest() throws Exception{
        Parcer parcer = new Parcer();
        System.out.println("Вычитание скаляра из скаляра...");
        String actualA = parcer.calc("A=5.2-2");
        assertEquals("3.2", actualA);
        String actualB= parcer.calc("B=-2--3");
        assertEquals("1.0", actualB);

    }

    @Test
    public void scalarMulScalarTest() throws Exception{
        Parcer parcer = new Parcer();
        System.out.println("Умножение скаляра на скаляр...");
        String actualA = parcer.calc("A=2*3");
        assertEquals("6.0", actualA);
        String actualB = parcer.calc("A=2*-3");
        assertEquals("-6.0", actualB);
    }

    @Test
    public void scalarDivScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Деление скаляра на скаляр...");
        String actualA = parcer.calc("A=6/3");
        assertEquals("2.0", actualA);
    }

    @Test
    public void vectorAddScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Сложение вектора и скаляра...");
        String actualA = parcer.calc("A={1, 2, 3}+1");
        assertEquals("{2.0, 3.0, 4.0}", actualA);
    }

    @Test
    public void vectorSubScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Вычитание из ветора скаляра...");
        String actualA = parcer.calc("A={3, 4, 5}-1");
        assertEquals("{2.0, 3.0, 4.0}", actualA);
    }

    @Test
    public void vectorMulScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Уможение вектора на скаляр...");
        String actualA = parcer.calc("A={3, 4, 5}*2");
        assertEquals("{6.0, 8.0, 10.0}", actualA);
    }

    @Test
    public void vectorDivScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Деление вектора на скаляр...");
        String actualA = parcer.calc("A={3, 4, 5}*2");
        assertEquals("{6.0, 8.0, 10.0}", actualA);
    }

    @Test
    public void vectorAddVectorTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Сложение вектора с вектором...");
        String actualA = parcer.calc("A={1, 2, 3}+{2, 3, 4}");
        assertEquals("{3.0, 5.0, 7.0}", actualA);
    }

    @Test
    public void vectorSubVectorTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Вычитание вектора из вектора...");
        String actualA = parcer.calc("A={3, 5, 7}-{2, 3, 4}");
        assertEquals("{1.0, 2.0, 3.0}", actualA);
    }

    @Test
    public void vectorMulVectorTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Умножение вектора на вектор...");
        String actualA = parcer.calc("A={1, 2, 3}*{2, 3, 4}");
        assertEquals("20.0", actualA);
    }

    @Test
    public void vectorMulMatrixTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Умножение вектора на матрицу...");
        String actualA = parcer.calc("{2, 3, 4}*{{1, 2, 3}, {3, 4, 5}}");
        assertEquals("{20.0, 38.0}", actualA);
    }

    @Test
    public void matrixAddScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Сложение матрицы и скаляра...");
        String actualA = parcer.calc("A={{1, 2, 3}, {2, 3, 4}}+2");
        assertEquals("{{3.0, 4.0, 5.0}, {4.0, 5.0, 6.0}}", actualA);
        String actualB = parcer.calc("{{1, 2}, {3, 4}}+1.0");
        assertEquals("{{2.0, 3.0}, {4.0, 5.0}}", actualB);

    }

    @Test
    public void matrixSubScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Вычитание из матрицы скаляра...");
        String actualA = parcer.calc("A={{1, 2, 3}, {2, 3, 4}}-2");
        assertEquals("{{-1.0, 0.0, 1.0}, {0.0, 1.0, 2.0}}", actualA);
    }

    @Test
    public void matrixMulScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Умножение матрицы и скаляра...");
        String actualA = parcer.calc("A={{1, 2, 3}, {2, 3, 4}}*2");
        assertEquals("{{2.0, 4.0, 6.0}, {4.0, 6.0, 8.0}}", actualA);
    }

    @Test
    public void matrixDivScalarTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Деление матрицы на скаляр...");
        String actualA = parcer.calc("A={{1, 2, 3}, {2, 3, 4}}/2");
        assertEquals("{{0.5, 1.0, 1.5}, {1.0, 1.5, 2.0}}", actualA);
    }

    @Test
    public void matrixAddMatrixTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Сложение матрицы и матрицы...");
        String actualA = parcer.calc("{{1, 2, 3}, {2, 3, 4}}+{{4, 5, 6}, {7, 8, 9}}");
        assertEquals("{{5.0, 7.0, 9.0}, {9.0, 11.0, 13.0}}", actualA);
    }

    @Test
    public void matrixSubMatrixTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Вычитание матрицы из матрицы...");
        String actualA = parcer.calc("{{1, 2, 3}, {2, 3, 4}}-{{4, 5, 6}, {7, 8, 9}}");
        assertEquals("{{-3.0, -3.0, -3.0}, {-5.0, -5.0, -5.0}}", actualA);
    }

    @Test
    public void matrixMulVectorTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Умножение матрицы и вектора...");
        String actualA = parcer.calc("{{1, 2, 3}, {2, 3, 4}}*{4, 5, 6}");
        assertEquals("{32.0, 47.0}", actualA);
    }

    @Test
    public void matrixMulMatrixTest() throws Exception {
        Parcer parcer = new Parcer();
        System.out.println("Умножение матрицы и матрицы...");
        String actualA = parcer.calc("{{1, 2, 3}, {3, 4, 5}}*{{3, 4}, {5, 6}, {7, 8}}");
        assertEquals("{{34.0, 40.0}, {64.0, 76.0}}", actualA);
    }

    @Test
    public void createScalar() {
        Object scalar = new Scalar(123.456);
        String s= scalar.toString();
        assertEquals("123.456", s);
    }
    @Test
    public void createVector() {
        String v = "{1, 2, 3}";
        Object vector = new Vector(v);
        String v1= vector.toString();
        assertEquals("{1.0, 2.0, 3.0}", v1);
    }

    @Test
    public void createMatrix() {
        String m = "{{1, 2, 3}, {4, 5, 6}}";
        Object matrix = new Matrix(m);
        String m1= matrix.toString();
        assertEquals("{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}", m1);
    }
}