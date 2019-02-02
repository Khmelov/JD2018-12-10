package by.it.skosirskiy.Calc;

public class Printer {

    void print(String str){

        if (str!=null)
            System.out.println(str);

    }




    void showError(CalcException e) {
        System.err.println(e.getMessage());
        Log.toLog(e.getMessage());
    }


}
