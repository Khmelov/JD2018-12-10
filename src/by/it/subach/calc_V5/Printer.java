package by.it.subach.calc_V5;


class Printer {
    void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
        Log.toLog(e.getMessage());
    }

}
