package by.it.titkovskaya.jd01.jd01_08.oop;

public class DeskLamp extends Lamp {

    private String lampModel;

    DeskLamp(String lampModel) {
        this.lampModel = lampModel;
    }

    DeskLamp(DeskLamp otherDeskLamp) {
        this.lampModel = otherDeskLamp.lampModel;
    }

    DeskLamp(int modelArt) {
        this.lampModel = "арт." + String.valueOf(modelArt);
    }

    @Override
    public void turnOn() {
        System.out.println("Модель " + this.lampModel + " включена");
    }

    @Override
    public void turnOff() {
        System.out.println("Модель " + this.lampModel + " выключена");
    }

    @Override
    public void failed(String failureNotification) {
        System.out.println("Лампа неисправна: "+failureNotification);
    }

    void failed(int numberOfFailureNotification) {
        System.out.print("Настольная лампа неисправна: ");
        if (numberOfFailureNotification==1) System.out.println("Требуется замена лампочки");
        else if (numberOfFailureNotification==2) System.out.println("Требуется замена источника питания");
        else if (numberOfFailureNotification==3) System.out.println("Требуется ремонт аппарата");
        else System.out.println("Причина не установлена");
    }

    void power(int lightPower, int lightsQuantity) {
        super.lightPower = lightPower;
        if (lightsQuantity > 1)
            System.out.println("Яркость лампы " + lightPower * lightsQuantity + " ватт ("
                    + lightsQuantity + " лампочки по " + lightPower + " ватт)");
        else super.power(this.lightPower);
    }

    void install(String installationType) {
        super.install();
        System.out.println(installationType);
    }

    @Override
    public String toString() {
        return ("Модель ") + this.lampModel;
    }
}
