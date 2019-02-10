package by.it.titkovskaya.calc;

class Printer {
    public void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        Log.toLog(e.getMessage());
    }

    void showCalculationInfo(String expression, String result) {
        if (result != null)
            Log.toLog(expression.replace("=", "")+"="+result);
    }
}
