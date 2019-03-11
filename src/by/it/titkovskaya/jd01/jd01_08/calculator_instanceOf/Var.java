package by.it.titkovskaya.jd01.jd01_08.calculator_instanceOf;

abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }

    public Var addCross(Scalar other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }

    public Var addCross(Vector other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }

    public Var addCross(Matrix other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }


    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " и " + other + " невозможно");
        return null;
    }

    public Var subCross(Scalar other) {
        System.out.println("Вычитание " + this + " и " + other + " невозможно");
        return null;
    }

    public Var subCross(Vector other) {
        System.out.println("Вычитание " + this + " и " + other + " невозможно");
        return null;
    }

    public Var subCross(Matrix other) {
        System.out.println("Вычитание " + this + " и " + other + " невозможно");
        return null;
    }


    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var mulCross(Scalar other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var mulCross(Vector other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var mulCross(Matrix other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }


    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    public Var divCross(Scalar other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    public Var divCross(Vector other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    public Var divCross(Matrix other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }


}
