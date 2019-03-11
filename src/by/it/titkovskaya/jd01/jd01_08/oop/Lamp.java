package by.it.titkovskaya.jd01.jd01_08.oop;

abstract class Lamp implements LightSource {

    int lightPower;

    void power(int lightPower) {
        this.lightPower = lightPower;
        System.out.println("Яркость лампы " + this.lightPower + " ватт");
    }

    void install() {
        System.out.println("Лампа установлена ");
    }

    void connectToPowerSupply() {
        System.out.println("Устройство подключено к источнику питания");
    }

    @Override
    public void turnOn() {
        System.out.println("Включение света");
    }

    @Override
    public void turnOff() {
        System.out.println("Выключение света");
    }

    @Override
    public void failed(String failureNotification) {
        System.out.println("Лампа неисправна");
    }

    @Override
    public String toString() {
        return "Неопределенный источник света";
    }
}
