package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions;

import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables.Var;

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
