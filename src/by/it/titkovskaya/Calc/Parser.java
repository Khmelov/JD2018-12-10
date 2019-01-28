package by.it.titkovskaya.Calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    static boolean printToLog = false;

    Var calc(String expression) throws CalcException {
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Pattern calc = Pattern.compile(Patterns.CALCULATION);
        Matcher matchCalc = calc.matcher(expression);
        printToLog=false;
        printToLog = matchCalc.find();
        String[] operands = expression.trim().split(Patterns.OPERATION);
        Var two = Var.createVar(operands[1]);
        Matcher matcher = p.matcher(expression);
        String operation = null;
        if (matcher.find()) {
            operation = matcher.group();
        }
        if (operation.equals("=")) {
            Var.saveVar(operands[0], two);
            return two;
        }

        Var one = Var.createVar(operands[0]);
        if (one == null || two == null) {
            System.err.println("Операция " + expression + " невозможна");
            return null;
        }
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
        return null;
    }
}
