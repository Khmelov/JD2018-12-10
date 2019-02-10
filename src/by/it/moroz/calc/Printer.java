package by.it.moroz.calc;


class Printer {

    private Log log = Log.getLogger();

    void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.out.println(e.getMessage());
        log.toLog(e.getMessage());
    }


}
