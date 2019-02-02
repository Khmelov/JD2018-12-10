package by.it.skosirskiy.Calc;

import by.it._examples_.jd01_11.Generics.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer  extends CalcException{

    private HashMap<String,Integer> prior=new HashMap<String, Integer>(){
        {
            this.put("=",0);
            this.put("+",1);
            this.put("-",1);
            this.put("*",2);
            this.put("/",2);
        }
    };

  public   String  calc(String expression) throws CalcException{
        if (expression.contains("printvar")) {
            Var.printvar();}
        else if (expression.contains("sortvar")) {
            Var.sortvar();}
        else {
        List<String> operands;
        List<String> operations;
        Pattern patternBrackets = Pattern.compile(Patterns.BRACKETS);
        Matcher matcherBrackets = patternBrackets.matcher(expression);
        while (matcherBrackets.find()){


            String buf = matcherBrackets.group();
            buf= buf.replace(")","");
            buf= buf.replace("(","");
            String res=calc(buf);
            buf="("+buf+")";
            expression=expression.replaceFirst(Patterns.BRACKETS,res);
            matcherBrackets.start();
            matcherBrackets = patternBrackets.matcher(expression);

        }

        Pattern oper = Pattern.compile(Patterns.OPERATION);
        String[] mas= expression.trim().split(Patterns.OPERATION);
        operands=new ArrayList<>(Arrays.asList(mas));
        operations= new ArrayList<>();
        Matcher matcher= oper.matcher(expression);
        while (matcher.find()){
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
        //вернем строку а не Var, так сказано в задании
        return res.toString();




        }
        return null;
    }
    private int getIndexOperation(List<String> operations) throws CalcException {
        //ищем операцию с самым высоким приоритетом
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
        //обработка одной комнады у нас уже была.
        //адаптируем ее под отдельный метод
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
