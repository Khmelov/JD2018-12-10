package by.it.yarmolenka.MathCalc;

import by.it.yarmolenka.MathCalc.Variables.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcTest {

    @Test
    public void testScalarAddScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("2+6").toString();
        assertEquals("8.0", res);
    }

    @Test
    public void testScalarSubScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("11-4").toString();
        assertEquals("7.0", res);
    }

    @Test
    public void testScalarMulScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("3*5").toString();
        assertEquals("15.0", res);
    }

    @Test
    public void testScalarDivScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("7/2").toString();
        assertEquals("3.5", res);
    }

    @Test
    public void testVectorAddVector() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{4.1, 4.2} + {4.6, 5.1}").toString();
        assertEquals("{8.7, 9.3}", res);
    }

    @Test
    public void testVectorAddScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{4.1, 4.2} + 7").toString();
        assertEquals("{11.1, 11.2}", res);
    }

    @Test
    public void testVectorSubScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{5.4, 2.2} - 5.4").toString();
        assertEquals("{0.0, -3.2}", res);
    }

    @Test
    public void testVectorSubVector() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{5.4, 2.2} - {1.4, 0.1}").toString();
        assertEquals("{4.0, 2.1}", res);
    }

    @Test
    public void testVectorMulScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{3.7, 1.1} * 2").toString();
        assertEquals("{7.4, 2.2}", res);
    }

    @Test
    public void testVectorMulVector() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{3.7, 1.7} * {2.4, 6.2}").toString();
        assertEquals("19.42", res);
    }

    @Test
    public void testVectorDivScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{5.5, 3.7} / 2").toString();
        assertEquals("{2.75, 1.85}", res);
    }

    @Test
    public void testMatrixAddScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2.4, 3.7}, {-3.6, 1.7}} + 2").toString();
        assertEquals("{{4.4, 5.7}, {-1.6, 3.7}}", res);
    }

    @Test
    public void testMatrixAddMatrix() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2.4, 3.7}, {3.1, 0.7}} + {{-1.7, 6.1}, {5.1, 6.6}}").toString();
        assertEquals("{{0.7, 9.8}, {8.2, 7.3}}", res);
    }

    @Test
    public void testMatrixSubMatrix() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2.4, 3.1}, {3.7, 4.7}} - {{-1.7, 6.7}, {5.7, 2.6}}").toString();
        assertEquals("{{4.1, -3.6}, {-2.0, 2.1}}", res);
    }

    @Test
    public void testMatrixSubScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2.4, 3.1}, {3.6, 6.5}} - 5").toString();
        assertEquals("{{-2.6, -1.9}, {-1.4, 1.5}}", res);
    }

    @Test
    public void testMatrixMulScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2.4, 3.1}, {3.6, 6.5}} * 5").toString();
        assertEquals("{{12.0, 15.5}, {18.0, 32.5}}", res);
    }

    @Test
    public void testMatrixMulVector() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2.4, 3.1, 2.4}, {3.6, 6.5, 7.1}} * {2.2, 8.1, 4.2}").toString();
        assertEquals("{40.47, 90.39}", res);
    }

    @Test
    public void testMatrixMulMatrix() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2, 1, 3}, {4, 2, 3}, {5, 2, 3}} * {{2, 3, 4}, {1, 5, 2}, {4, 2, 3}}").toString();
        assertEquals("{{17.0, 17.0, 19.0}, {22.0, 28.0, 29.0}, {24.0, 31.0, 33.0}}", res);
    }

    @Test
    public void testMatrixDivScalar() throws Exception{
        Parcer p = new Parcer();
        String res = p.calc("{{2, 5, 3}, {4, 2, 3}, {5, 7, 9}} / 2").toString();
        assertEquals("{{1.0, 2.5, 1.5}, {2.0, 1.0, 1.5}, {2.5, 3.5, 4.5}}", res);
    }

    @Test
    public void testCreatingScalar() throws CalcException {
        CreatorVar creator = new CreatorVar();
        Scalar sc = (Scalar) creator.getVar("-5.3");
        assertEquals("-5.3", sc.toString());
    }

    @Test
    public void testCreatingVector() throws CalcException {
        CreatorVar creator = new CreatorVar();
        Vector vec = (Vector) creator.getVar("{4.8, -7.2, -5.2}");
        assertEquals("{4.8, -7.2, -5.2}", vec.toString());
    }

    @Test
    public void testCreatingMatrix() throws CalcException {
        CreatorVar creator = new CreatorVar();
        Matrix m = (Matrix) creator.getVar("{{5.2, -8.1, 4.7}, {-2.2, -6.6, 8.3}}");
        assertEquals("{{5.2, -8.1, 4.7}, {-2.2, -6.6, 8.3}}", m.toString());
    }
}
