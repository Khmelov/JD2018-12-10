package by.it.titkovskaya.jd01.jd01_10;
/*
TaskA2. Создайте класс Bean который содержит два статических и два нестатических метода.
Имена sum max min avg с сигнатурой (int a, int b), какие именно из них статические выберите
произвольно. Методы должны вычислять для своих параметров a и b сумму, максимум, минимум и
среднее и возвращать результат как double. Три из этих методов должны быть помечены ранее
созданной аннотацией с разными значениями a и b
 */
class Bean {

    @Param(a = 10, b = 20)
    double sum(int x, int y) {
        return x + y;
    }

    static double max(int d, int z) {
        return d > z ? d : z;
    }

    @Param(a = 10, b = 5)
    double min(int a1, int a2) {
        return a1 < a2 ? a1 : a2;
    }

    @Param(a = 20, b = 3)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
