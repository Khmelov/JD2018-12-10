package by.it.zagurskaya.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    private HashMap<String, Integer> prior = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };


    String calc(String expression) throws CalcException {
        //найдем скобки
//        D=((C-0.15)-20)/(7-5)
        int bracketCloseIndex = expression.indexOf(")");
        while (bracketCloseIndex != -1) {
            int bracketOpenIndex = expression.lastIndexOf("(", bracketCloseIndex);
            String bracketExpression = expression.substring(bracketOpenIndex + 1, bracketCloseIndex);
            String bracketResult = calc(bracketExpression);
            expression = expression.replace("(" + bracketExpression + ")", bracketResult);
            bracketCloseIndex = expression.indexOf(")");
        }

        List<String> operands;
        List<String> operations;

        Pattern oper = Pattern.compile(Patterns.OPERATION);
        //найдем операнды
        String[] mas = expression.trim().split(Patterns.OPERATION);
        operands = new ArrayList<>(Arrays.asList(mas));
        operations = new ArrayList<>();

        //найдем операции
        Matcher matcher = oper.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        //выполним все операции
        while (operations.size() > 0) {
            int indexOperation = getIndexOperation(operations);
            String one = operands.remove(indexOperation);
            String op = operations.remove(indexOperation);
            String two = operands.remove(indexOperation);
            String result = oneOperation(one, op, two);
            operands.add(indexOperation, result);
        }
        Var res = VarCreator.getInstance().create(operands.get(0));
        //вернем строку а не Var, так сказано в задании
        return res.toString();

    }

    private int getIndexOperation(List<String> operations) throws CalcException {
        //ищем операцию с самым высоким приоритетом
        int res = -1;
        int p = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (p < prior.get(op)) {
                res = i;
                p = prior.get(op);
            }
        }
        if (res > -1)
            return res;
        else {
            String message = LocalMessages.UNEXPECTED_COMPLETION_OF_CALCULATIONS_SUPPLIER.get();
            throw new CalcException(message); //unexpectedCompletionOfCalculations
        }
    }

    private String oneOperation(String strOne, String operation, String strTwo) throws CalcException {
        //обработка одной комнады у нас уже была.
        //адаптируем ее под отдельный метод
        Var two = VarCreator.getInstance().create(strTwo);
        if (operation.equals("=")) {
            VarCreator.getInstance().saveVar(strOne, two);
            return two.toString();
        }

        Var one = VarCreator.getInstance().create(strOne);
        if (one == null || two == null) {
            String message = LocalMessages.ACTION_SUPPLIER.get() + operation + LocalMessages.IMPOSSIBLE_SUPPLIER.get();
            System.err.println(message);//action impossible
            return null;
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
//        }
        String message = LocalMessages.UNEXPECTED_COMPLETION_OF_CALCULATIONS_SUPPLIER.get();
        throw new CalcException(message); //unexpectedCompletionOfCalculations

    }
}
