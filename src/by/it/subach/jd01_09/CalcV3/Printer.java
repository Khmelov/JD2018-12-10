package by.it.subach.jd01_09.CalcV3;


class Printer {
    public void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
    }

}
