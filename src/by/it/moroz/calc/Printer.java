package by.it.moroz.calc;


class Printer {

    void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.out.println(e.getMessage());
        Log.toLog(e.getMessage());
    }


}
