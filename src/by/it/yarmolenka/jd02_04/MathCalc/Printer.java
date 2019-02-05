package by.it.yarmolenka.jd02_04.MathCalc;

import by.it.yarmolenka.jd02_04.MathCalc.Variables.Var;

class Printer {
    void print(Var result){
        if (result != null)
        System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
        Log.addToLog(e.getMessage());
    }
}
