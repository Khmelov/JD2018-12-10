package by.it.a_khmelev.jd02_03;

public class R1000 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Dispatcher.reset();
            Runner.main(new String[0]);
        }
    }
}
