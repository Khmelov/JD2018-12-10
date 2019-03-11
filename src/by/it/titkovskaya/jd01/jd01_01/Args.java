package by.it.titkovskaya.jd01.jd01_01;

class Args {
    private String[] args;

    Args(String[] args) {
        this.args=args;
    }

    void printArgs(){
        int i = 0;
        for (String arg: args) {
            i++;
            System.out.println("Аргумент "+i+"="+arg);
        }
    }
}
