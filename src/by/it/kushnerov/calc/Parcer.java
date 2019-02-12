package by.it.kushnerov.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {

    private HashMap<String,Integer> prior=new HashMap<String, Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };

    String calc(String expression) throws CalcException {
        List<String> operands;
        List<String> operations;
        Pattern oper = Pattern.compile(Patterns.OPERATION);

        String[] mas = expression.trim().split(Patterns.OPERATION);
        operands = new ArrayList<>(Arrays.asList(mas));
        operations=new ArrayList<>();

        Matcher matcher = oper.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }

        while (operations.size()>0){
            int indexOperation=getIndexOperation(operations);
            String one=operands.remove(indexOperation);
            String op=operations.remove(indexOperation);
            String two=operands.remove(indexOperation);
            String result=oneOperation(one,op,two);
            operands.add(indexOperation,result);
        }
        Var res=Var.createVar(operands.get(0));

        return res.toString();

    }

    private int getIndexOperation(List<String> operations) throws CalcException {

        int res=-1;
        int p=-1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (p < prior.get(op)) {
                res=i;
                p=prior.get(op);
            }
        }
        if (res>-1)
            return res;
        else
            throw new CalcException("Неожиданное завершение вычислений");
    }

    private String oneOperation(String strOne, String operation, String strTwo) throws CalcException {


        Var two = Var.createVar(strTwo);
        if (operation.equals("=")) {
            Var.saveVar(strOne, two);
            return two.toString();
        }

        Var one = Var.createVar(strOne);
        if (one == null || two == null) {
            System.err.println("Операция " + operation + " невозможна");
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

        throw new CalcException("Неожиданное завершение вычислений");
    }
}
