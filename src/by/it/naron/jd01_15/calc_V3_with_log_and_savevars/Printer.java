package by.it.naron.jd01_15.calc_V3_with_log_and_savevars;

class Printer {

    void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
        Log.toLog(e.getMessage());
    }
}
