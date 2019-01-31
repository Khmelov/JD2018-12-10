package by.it.kushnerov.jd02_02;

public class Cashier implements Runnable {

    private String name;

    public Cashier(int number){
        name ="Cashier №"+number;
    }

    @Override
    public void run() {
        System.out.println(this+" opened");

        System.out.println(this+" closed");
    }

    @Override
    public String toString() {
        return name;
    }
}
