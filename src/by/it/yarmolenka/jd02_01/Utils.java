package by.it.yarmolenka.jd02_01;

class Utils {
    static int getRandom(int min, int max){
        return (int) (min + Math.random()*(max-min+1));
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static String getRandomGoods() {
        int goodNumber = getRandom(1, Goods.priceList.size());
        switch (goodNumber){
            case 1: return "хлеб";
            case 2: return "молоко";
            case 3: return "кефир";
            case 4: return "колбаса";
            case 5: return "сыр";
            case 6: return "мандарины";
            case 7: return "чай";
            case 8: return "батон";
            case 9: return "огурцы";
            case 10: return "пельмени";
            case 11: return "яйца";
            default: return null;
        }
    }
}
