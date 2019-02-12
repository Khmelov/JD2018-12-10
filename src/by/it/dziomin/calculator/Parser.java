package by.it.dziomin.calculator;


import by.it.dziomin.calculator.vars.Var;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.dziomin.calculator.Patterns.OPERATION;

public class Parser {

    private static final int KOEF = 10;
    private List<OperationPriority> operations = new ArrayList<>();
    private List<String> operands;
    private LinkedList<Bracket> bracketLinkedList = new LinkedList<>();

    public Var calc(String expression) throws CalcException {

        Pattern pattern = Pattern.compile(OPERATION);
        Matcher matcher = pattern.matcher(expression);
        operands = new ArrayList<>(Arrays.asList(expression.trim().split(OPERATION)));
        Var result = null;
        Localizer.setLocale(expression);
        Localizer.setBundle(Localizer.getLocale());
        if (Localizer.changeLanguage) {
            Localizer.displayNotice();
            Localizer.changeLanguage = false;
        }

        parseOperations(matcher);
        result = processOperations(result);
        return result;
    }

    private void parseOperations(Matcher matcher) throws CalcException {
        int priorityCoef = 0;

        while (matcher.find()) {
            String operationSymbols = matcher.group();
            boolean calExist = false;
            for (char symbol : operationSymbols.toCharArray()) {
                Operation operation = Operation.getOperationBySymbol(symbol);
                if (operation != null) {
                    int currentPriorityLevel;
                    if (calExist) {
                        if (operation == Operation.MINUS) {
                            currentPriorityLevel = operation.defaultPriorityLevel + priorityCoef + KOEF;
                            operands.add(operations.size(), "0");
                        } else {
                            throw new CalcException(Localizer.getBundle().getString(Localization.WRONG_EXPRESSION) + " " + symbol);
                        }
                    } else {
                        calExist = true;
                        currentPriorityLevel = operation.defaultPriorityLevel + priorityCoef;
                    }
                    OperationPriority operationPriority = new OperationPriority(operation, currentPriorityLevel);
                    operations.add(operationPriority);
                } else {
                    priorityCoef = priorityCoef + checkBracketCorrection(symbol);
                }
            }
        }
    }

    private Var processOperations(Var result) throws CalcException {
        while (operations.size() > 0) {
            int position = getMaxLevelOperationPosition();
            OperationPriority operation = operations.remove(position);

            String value1 = operands.get(position);
            String value2 = operands.remove(position + 1);
            result = oneOperationCalc(value1, operation.operation, value2);
            operands.set(position, result.toString());

        }
        return result;
    }

    private int checkBracketCorrection(char symbol) throws CalcException {
        Bracket bracket = Bracket.getBracketBySymbol(symbol);

        if (bracket == null) {
            throw new CalcException(Localizer.getBundle().getString(Localization.UNKNOWN_VALUE) + " " + symbol);
        }

        if (bracket == Bracket.OPEN) {
            bracketLinkedList.add(bracket);
        } else {
            if (bracketLinkedList.isEmpty()) {
                throw new CalcException(Localizer.getBundle().getString(Localization.WRONG_EXPRESSION) + " " + symbol);
            } else {
                bracketLinkedList.pollLast();
            }
        }

        return bracket.correction;
    }

    private Var oneOperationCalc(String v1, Operation op, String v2) throws CalcException {
        Var one = Var.createVar(v1);
        if (one == null && op != Operation.EQ) {
            throw new CalcException(Localizer.getBundle().getString(Localization.UNKNOWN_VALUE) + " " + v1);
        }
        Var two = Var.createVar(v2);
        if (two == null) {
            throw new CalcException(Localizer.getBundle().getString(Localization.UNKNOWN_VALUE) + " " + v2);
        }
        switch (op) {
            case EQ:
                Var.saveVar(v1, two);
                return two;
            case PLAS:
                return one.add(two);
            case MINUS:
                return one.sub(two);
            case MULT:
                return one.mul(two);
            case DIV:
                return one.div(two);
        }
        return null;
    }

    private int getMaxLevelOperationPosition() {
        OperationPriority maxPriorityOperation = operations.stream()
                .max(Comparator.comparingInt(o -> o.currentPriorityLevel))
                .orElse(operations.get(0));
        return operations.indexOf(maxPriorityOperation);
    }

    enum Operation {

        EQ('=', 1),
        PLAS('+', 2),
        MINUS('-', 3),
        MULT('*', 4),
        DIV('/', 5);

        private char symbol;
        private int defaultPriorityLevel;

        Operation(char symbol, int defaultPriorityLevel) {
            this.symbol = symbol;
            this.defaultPriorityLevel = defaultPriorityLevel;
        }

        static Operation getOperationBySymbol(char symbol) {
            for (Operation operation : Operation.values()) {
                if (operation.symbol == symbol) {
                    return operation;
                }
            }
            return null;
        }
    }

    enum Bracket {
        OPEN('(', KOEF), CLOSE(')', -KOEF);

        private char symbol;
        private int correction;

        Bracket(char symbol, int correction) {
            this.symbol = symbol;
            this.correction = correction;
        }

        static Bracket getBracketBySymbol(char symbol) {
            for (Bracket bracket : Bracket.values()) {
                if (bracket.symbol == symbol) {
                    return bracket;
                }
            }
            return null;
        }
    }

    class OperationPriority {

        private Operation operation;
        private int currentPriorityLevel;

        OperationPriority(Operation operation, int currentPriorityLevel) {
            this.operation = operation;
            this.currentPriorityLevel = currentPriorityLevel;
        }

        public Operation getOperation() {
            return operation;
        }

        public void setOperation(Operation operation) {
            this.operation = operation;
        }
    }

}
