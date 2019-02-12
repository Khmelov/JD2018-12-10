package by.it.subach.Calc_V6_fabric_and_logging;


class Printer {

    Logger logger = Logger.getLogger();

    void print(String result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
    }

}
