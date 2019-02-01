package by.it.a_khmelev.calc_v4_with_multioperation_and_tests;

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
