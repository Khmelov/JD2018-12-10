package by.it.titkovskaya.Calc;

class Printer {
    public void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        Log.toLog(e.getMessage());
    }

    void showCalculationInfo(String expression, Var result) {
        if (result != null)
            Log.toLog(expression.replace("=", "")+"="+result);
    }
}
