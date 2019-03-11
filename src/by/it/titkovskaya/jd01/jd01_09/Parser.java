package by.it.titkovskaya.jd01.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) {
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Var one = Var.createVar(operands[0]);
        Var two = Var.createVar(operands[1]);
        if (one == null || two == null) {
            System.err.println("Операция " + expression + " невозможна");
            return null;
        }
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = p.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
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
