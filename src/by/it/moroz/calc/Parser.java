package by.it.moroz.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private VarFactory varFactory = new VarFactory();
    private Variables variables = Variables.getVariables();

    private static final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
            this.put(")", 3);
        }
    };

    String calc(String input) throws CalcException {
        List<String> operands;
        List<String> operations;
        Pattern oper = Pattern.compile(Patterns.OPERATION);

        //найдем операнды
        String[] mas = input.trim().split(Patterns.OPERATION);
        operands = new ArrayList<>();
        for (String ma : mas) {
            if (!ma.equals("")) operands.add(ma);
        }
        operations = new ArrayList<>();

        //найдем операции
        Matcher matcher = oper.matcher(input);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        //выполним все операции
        while (operations.size() > 0) {
            int indexOperation = getIndexOperation(operations);
            if (operations.get(indexOperation).equals(")")) {
                String one = operands.remove(indexOperation - 1);
                operations.remove(indexOperation);
                String op = operations.remove(indexOperation - 1);
                String two = operands.remove(indexOperation - 1);
                String result = oneOperation(one.replaceAll("\\(", ""), op, two);
                operands.add(indexOperation - 1, result);
            } else {
                String one = operands.remove(indexOperation);
                String op = operations.remove(indexOperation);
                String two = operands.remove(indexOperation);
                String result = oneOperation(one, op, two);
                operands.add(indexOperation, result);
            }
        }
        Var result = varFactory.createVar(operands.get(0));
        //вернем строку а не Var, так сказано в задании
        return result.toString();
    }

    private String oneOperation(String strOne, String operation, String strTwo) throws CalcException {
        //обработка одной комнады
        Var two = varFactory.createVar(strTwo);
        assert operation != null;
        if (operation.equals("=")) {
            variables.saveVar(strOne, two);
            return two.toString();
        }

        Var one = varFactory.createVar(strOne);
        if (one == null || two == null) {
            throw new CalcException(ResMan.INSTANCE.getError(Errors.IMPOSSIBLE));
        }
        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
        }
        return null;
    }

    private int getIndexOperation(List<String> operations) throws CalcException {
        //ищем операцию с самым высоким приоритетом
        int res = -1;
        int p = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (p < priority.get(op)) {
                res = i;
                p = priority.get(op);
            }
            if (p == 3) {
                return res;
            }
        }
        if (res > -1)
            return res;
        else
            throw new CalcException(ResMan.INSTANCE.getError(Errors.UNEXPECTED));
    }


}
