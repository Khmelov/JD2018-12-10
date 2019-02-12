package by.it.titkovskaya.calculator;

import by.it.titkovskaya.calculator.internationalization.strings.Programme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    static boolean printToLog = false;

    private HashMap<String, Integer> operationsPriority = new HashMap<String, Integer>() {
        {
            this.put("*", 2);
            this.put("/", 2);
            this.put("+", 1);
            this.put("-", 1);
            this.put("=", 0);
        }
    };

    String calc(String expression) throws CalcException {

        Pattern calc = Pattern.compile(Patterns.CALCULATION);
        Matcher matchCalc = calc.matcher(expression);
        printToLog = false;
        printToLog = matchCalc.find();

        //получим выражение без скобок приоритета
        expression = getExpressionWithoutPriority(expression);
        //рассчитаем выражение согласно знакам приоритета
        return getCalculationResult(expression);
    }

    private String getExpressionWithoutPriority(String expression) throws CalcException {

        //проверим, есть ли приоритетные операции, выделенные скобками
        Pattern priorOperation = Pattern.compile(Patterns.PRIOR_OPERATION);
        Matcher matcherPrior = priorOperation.matcher(expression);
        if (matcherPrior.find()) {
            String operationPrior = matcherPrior.group();
            String operationPriorResult = getCalculationResult(operationPrior.replace("(","")
                    .replace(")",""));
            expression=expression.replace(operationPrior,operationPriorResult);
            expression=getExpressionWithoutPriority(expression);
        }
        return expression;
    }

    private String getCalculationResult(String expression) throws CalcException {
        List<String> operands;
        List<String> operations;
        Pattern operation = Pattern.compile(Patterns.OPERATION);

        //находим все операнды
        String[] allOperands = expression.trim().split(Patterns.OPERATION);
        operands = new ArrayList<>(Arrays.asList(allOperands));

        //находим все операции
        operations = new ArrayList<>();
        Matcher matcher = operation.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        //выполним все операции в соответствии с их приоритом (очередностью выполнения)
        while (operations.size() > 0) {
            int indexOfOperation = getIndexOfOperation(operations);
            String operandOne = operands.remove(indexOfOperation);
            String operationToDo = operations.remove(indexOfOperation);
            String operandTwo = operands.remove(indexOfOperation);
            String result = oneOperation(operandOne, operationToDo, operandTwo);
            operands.add(indexOfOperation, result);
        }
        Var result = Var.createVar(operands.get(0));
        return result.toString();
    }

    private int getIndexOfOperation(List<String> operations) throws CalcException {
        //ищем индекс операции с самым высоким приоритетом
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (priority < operationsPriority.get(operation)) {
                index = i;
                priority = operationsPriority.get(operation);
            }
        }
        if (index > -1)
            return index;
        else
            throw new CalcException(ResMan.INSTANCE.get(Programme.ERROR_UNEXPECTED_RESULT));
    }

    private String oneOperation(String operandOne, String operationToDo, String operandTwo) throws CalcException {
        Var two = Var.createVar(operandTwo);
        if (operationToDo.equals("=")) {
            Var.saveVar(operandOne, two);
            return two.toString();
        }

        Var one = Var.createVar(operandOne);
        if (one == null || two == null) {
            System.err.println(ResMan.INSTANCE.get(Programme.OPERATION) + " " + operationToDo + " "
                    + ResMan.INSTANCE.get(Programme.IMPOSSIBLE));
            return null;
        }
        switch (operationToDo) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
        }
        throw new CalcException(ResMan.INSTANCE.get(Programme.ERROR_UNEXPECTED_RESULT));
    }

}
