package by.it.dziomin.calculator;


import by.it.dziomin.calculator.vars.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        Var one;
        Var two;
        String operation = null;

        if (matcher.find()) {
            operation = matcher.group();

            if (operation.equals("=")) {
                two = Var.createVar(operands[1]);
                Var.saveVar(operands[0], two);
                return two;
            }
        }

        if (operands.length > 1) {


            one = Var.createVar(operands[0]);
            two = Var.createVar(operands[1]);
        } else {

            throw new CalcException("Не определены операнды!");
        }

        if (one == null) {
            throw new CalcException("Первый операнд не определен!");
        }

        if (two == null) {
            throw new CalcException("Второй операнд не определен!");
        }

        matcher = pattern.matcher(expression);
        if (matcher.find()) {
            operation = matcher.group();
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
        return null;
    }
}
