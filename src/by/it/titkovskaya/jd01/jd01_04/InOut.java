package by.it.titkovskaya.jd01_04;


public class InOut {
    static double[ ] getArray(String line){
        line=line.trim();
        String[] strArr = line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i==arr.length-1)
                System.out.println();
        }
    }
}
