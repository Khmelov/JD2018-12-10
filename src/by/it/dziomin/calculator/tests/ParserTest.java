package by.it.dziomin.calculator.tests;

import by.it.dziomin.calculator.CalcException;
import by.it.dziomin.calculator.Parser;
import by.it.dziomin.calculator.vars.Matrix;
import by.it.dziomin.calculator.vars.Var;
import org.junit.Test;

public class ParserTest {
    private Parser parser = new Parser();
    private String expression;
    private Var result;

    @Test
    public void calcTestA1() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "2-3";
        result = parser.calc(expression);
        System.out.println("Expected: -1.0");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("-1.0"));
    }

    @Test
    public void calcTestA2() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "4-1";
        result = parser.calc(expression);
        System.out.println("Expected: 3.0");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("3.0"));
    }

    @Test
    public void calcTestA3() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "A=2+5.3";
        result = parser.calc(expression);
        System.out.println("Expected: 7.3");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("7.3"));
    }

    @Test
    public void calcTestA4() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "B=A*3.5";
        result = parser.calc(expression);
        System.out.println("Expected: 25.55");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("25.55"));
    }

    @Test
    public void calcTestA5() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "B1=B+0.11*-5";
        result = parser.calc(expression);
        System.out.println("Expected: 25.0");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("25.0"));
    }

    @Test
    public void calcTestA6() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "B2=A/2-1";
        result = parser.calc(expression);
        System.out.println("Expected: 2.65");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("2.65"));
    }

    @Test
    public void calcTestB1() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "C=B+(A*2)";
        result = parser.calc(expression);
        System.out.println("Expected: 40.15");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("40.15"));
    }

    @Test
    public void calcTestB2() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "D=((C-0.15)-20)/(7-5)";
        result = parser.calc(expression);
        System.out.println("Expected: 10.0");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("10.0"));
    }

    @Test
    public void calcTestB3() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "E={2,3}*(D/2)";
        result = parser.calc(expression);
        System.out.println("Expected: {10,15}");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("{10,15}"));
    }

    @Test
    public void calcTestB4() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "E=({10,15}+{5,0})/3";
        result = parser.calc(expression);
        System.out.println("Expected: {5,5}");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("{5,5}"));
    }

    @Test
    public void calcTestC1() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "{{1, 2}, {3, 4}}+{{4, 5}, {7, 8}}";
        result = parser.calc(expression);
        System.out.println("Expected: {{5.0, 7.0}, {10.0, 12.0}}");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("{{5.0, 7.0}, {10.0, 12.0}}"));
    }

    @Test
    public void calcTestC2() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "{{1, 2}, {3, 4}} - {{4, 5}, {7, 8}}";
        result = parser.calc(expression);
        System.out.println("Expected: {{-3.0, -3.0}, {-4.0, -4.0}}");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(new Matrix("{{-3.0, -3.0}, {-4.0, -4.0}}"));
    }

    @Test
    public void calcTestC3() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "{{1, 2}, {3, 4}} * {5, 6}";
        result = parser.calc(expression);
        System.out.println("Expected: {17.0, 39.0}");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("{17.0, 39.0}"));
    }

    @Test
    public void calcTestC4() throws CalcException, NullPointerException {
        System.out.println("\n-------------------------------------------------------");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        expression = "{{1, 2}, {3, 4}} * {{4, 5}, {7, 8}}";
        result = parser.calc(expression);
        System.out.println("Expected: {{18.0, 21.0}, {40.0, 47.0}}");
        System.out.print("Actual:   ");
        System.out.println(result);
        assert result.equals(Var.createVar("{{18.0, 21.0}, {40.0, 47.0}}"));
    }

}