package by.it.yarmolenka.MathCalc;

import by.it.yarmolenka.MathCalc.Operations.*;
import by.it.yarmolenka.MathCalc.Variables.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Var calc(String expression) throws CalcException {

        if (expression.matches(Patterns.SCALAR)) return new Scalar(expression);
        if (expression.matches(Patterns.VECTOR)) return new Vector(expression);
        if (expression.matches(Patterns.MATRIX)) return new Matrix(expression);
        if (expression.matches(Patterns.VARIABLE)) return Var.getVariable(expression);

        expression = calcBrackets(expression);

        Pattern cal = Pattern.compile(Patterns.OPERATION);
        Matcher m = cal.matcher(expression);
        List<String> list = new ArrayList<>();
        while (m.find()) list.add(m.group());
        String[] split = expression.trim().split(Patterns.OPERATION);

        for (int i = 0; i < split.length; i++)
            split[i]=split[i].trim();

        if (list.get(0).equals("=")) {
            return identificationOfVariable(expression, split);
        }


        for (int i = 0; i < list.size(); i++) {
            mulDivActions(list, split, i);
        }

        for (int i = 0; i < list.size(); i++) {
            addSubActions(list, split, i);
        }

        Var res = Var.createVar(split[split.length - 1]);
        Log.addToLog(expression + " = " + res);
        return res;
    }

    private void addSubActions(List<String> list, String[] split, int i) throws CalcException {
        if (list.get(i) == null) return;
        if (list.get(i).equals("+")) {
            Var one = Var.createVar(split[i]);
            Var two = null;
            int k = 0;
            for (int j = i + 1; j < split.length; j++)
                if (split[j] != null) {
                    two = Var.createVar(split[j]);
                    k = j;
                    break;
                }
            Var res = Add.addVarVar(one, two);
            split[k] = res.toString();
            split[i] = null;
            list.set(i, null);
            return;
        }
        if (list.get(i).equals("-")) {
            Var one = Var.createVar(split[i]);
            Var two = null;
            int k = 0;
            for (int j = i + 1; j < split.length; j++)
                if (split[j] != null) {
                    two = Var.createVar(split[j]);
                    k = j;
                    break;
                }
            Var res = Sub.subVarVar(one, two);
            split[k] = res.toString();
            split[i] = null;
            list.set(i, null);
        }
    }

    private void mulDivActions(List<String> list, String[] split, int i) throws CalcException {
        if (list.get(i).equals("*")) {
            Var one = Var.createVar(split[i]);
            Var two = Var.createVar(split[i + 1]);
            Var res = Mul.mulVarVar(one, two);
            split[i + 1] = res.toString();
            split[i] = null;
            list.set(i, null);
            return;
        }
        if (list.get(i).equals("/")) {
            Var one = Var.createVar(split[i]);
            Var two = Var.createVar(split[i + 1]);
            Var res = Div.divVarVar(one, two);
            split[i + 1] = res.toString();
            split[i] = null;
            list.set(i, null);
        }
    }

    private Var identificationOfVariable(String expression, String[] split) throws CalcException {
        if (!split[0].trim().matches(Patterns.VARIABLE))
            throw new CalcException("в названии переменной допускаются латинские буквы и цифры");
        Var res;
        if (split.length == 2)
            res = Var.createVar(split[1]);
        else
            res = calc(expression.substring(expression.indexOf('=') + 1));
        Var.addVar(split[0], res);
        return res;
    }

    private String calcBrackets(String expression) throws CalcException {
        Pattern bra = Pattern.compile(Patterns.BRACKETS);
        Matcher m1 = bra.matcher(expression);
        while (m1.find()) {
            Var res = calc(m1.group().substring(1, m1.group().length() - 1));
            expression = expression.replace(m1.group(), res.toString());
        }
        return expression;
    }
}
