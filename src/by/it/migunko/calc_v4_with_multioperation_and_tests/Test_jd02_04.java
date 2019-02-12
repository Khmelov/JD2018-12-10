package by.it.migunko.calc_v4_with_multioperation_and_tests;
import org.junit.Test;

import static org.junit.Assert.*;
public class Test_jd02_04 {
    @Test
    public void Task_A() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("A=2+5.3");
        assertEquals("Error Test","7.3",actual);

        actual=parser.calc("B=A*3.5");
        assertEquals("Error Test","25.55",actual);

        actual=parser.calc("B1=B+0.11*-5");
        assertEquals("Error Test","25.0",actual);

        actual=parser.calc("B2=A/2-1");
        assertEquals("Error Test","2.65",actual);
    }

    @Test
    public void Task_B() throws Exception{
        Parser parser=new Parser();
        String actual=parser.calc("C=B+(A*2)");
        assertEquals("Error Test","40.15",actual);

        actual=parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("Error Test","10.0",actual);

        actual=parser.calc("E={2,3}*(D/2)");
        assertEquals("Error Test","{10.0, 15.0}",actual);
    }

    @Test
    public void operationsWithScalars() throws Exception{
        Parser parser = new Parser();
        String result = parser.calc("2.0+2.0");
        assertEquals("Ошика сложения скаляров","4.0", result);

        result = parser.calc("8.0-6.0");
        assertEquals("Ошика вычетания скаляров","2.0", result);

        result = parser.calc("1.0*5.0");
        assertEquals("Ошика умножения скаляров","5.0", result);

        result = parser.calc("8.0/4.0");
        assertEquals("Ошика деления скаляров","2.0", result);
    }

    @Test
    public void operationsWithVectors() throws Exception{
        Parser parser = new Parser();
        String result = parser.calc("{1,2,3}+{3,2,1}");
        assertEquals("Ошика сложения векторов","{4.0, 4.0, 4.0}", result);

        result = parser.calc("{6,8,3}-{4,4,6}");
        assertEquals("Ошика вычетания векторов","{2.0, 4.0, -3.0}", result);

        result = parser.calc("{1,2,3}*{5,0,3}");
        assertEquals("Ошика умножения векторов","{5.0, 0.0, 9.0}", result);

        result = parser.calc("{1,2,3}+2");
        assertEquals("Ошика сложения вектора и скаляра","{3.0, 4.0, 5.0}", result);

        result = parser.calc("{2,4,5}*5");
        assertEquals("Ошика умножения вектора на скаляр","{10.0, 20.0, 25.0}", result);
    }

    @Test
    public void createVars(){
        Var scalar = Var.createVar("3");
        Var vector = Var.createVar("{1,2,3}");
        assertEquals("Ошика создания/вывода скаляра","3.0", scalar.toString());
        assertEquals("Ошика создания/вывода вектора","{1.0, 2.0, 3.0}", vector.toString());

    }
}
