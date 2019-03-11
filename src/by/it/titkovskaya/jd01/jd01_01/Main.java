package by.it.titkovskaya.jd01.jd01_01;

public class Main {
    public static void main(String[] args) {

        Hello hello=new Hello();
        hello.printSlogan();
        hello.setSlogan("Привет мир!");
        hello.printSlogan();

        Args name=new Args(args);
        name.printArgs();
    }
}
