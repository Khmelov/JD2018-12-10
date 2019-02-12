package by.it.skosirskiy.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer  extends CalcException{

    Var calc(String expression) throws CalcException{
        String[] operand = expression.split(Patterns.OPERATION);


        if (expression.contains("printvar")) {
            Var.printvar();}
        else if (expression.contains("sortvar")) {
            Var.sortvar();}
        else {
            if(!(operand.length==2)){throw new CalcException("не коррекнтый вод "+operand[0]);}
            Var two = Var.createVar(operand[1]);
            if (expression.contains("=")) {
                 Var.saveVar(operand[0], two);
                return two;
            }
            Var one = Var.createVar(operand[0]);
            if (one == null || two == null)
                return null; //TODO create error
            Pattern p = Pattern.compile(Patterns.OPERATION);
            Matcher m = p.matcher(expression);
            if (m.find()) {

                String operation = m.group();
                switch (operation) {
                    case "+":
                        return one.add(two);
                    case "-":
                        return one.sub(two);
                    case "*":
                        return one.mul(two);
                    case "/":
                        return one.div(two);
                }

            }
        }
        return null;
    }

}
