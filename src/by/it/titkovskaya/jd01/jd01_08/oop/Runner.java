package by.it.titkovskaya.jd01.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        DeskLamp lamp1 = new DeskLamp("\"Светлячок\"");
        Lamp lamp2 = new DeskLamp(lamp1);
        DeskLamp lamp3 = new DeskLamp(123);
        System.out.println(lamp1);
        System.out.println(lamp2);
        System.out.println(lamp3);
        lamp1.connectToPowerSupply();
        lamp2.install();
        lamp3.install("на столе");
        lamp1.install("креплением к столешнице");
        lamp1.turnOn();
        lamp2.turnOn();
        lamp3.turnOff();
        lamp1.power(50);
        ((DeskLamp) lamp2).power(15,4);
        lamp3.power(40,1);
        lamp3.power(20,3);
        lamp1.failed("Требуется замена лампочки");
        lamp2.failed("Требуется замена источника питания");
        ((DeskLamp) lamp2).failed(5);
        lamp3.failed(3);
    }
}
