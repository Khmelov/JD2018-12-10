package by.it.titkovskaya.jd01.jd01_02;

public class Step3 {
    private static int[][] step3old(int[][] mas) {
        Boolean[] delCol = new Boolean[mas[0].length];
        Boolean[] delRow = new Boolean[mas.length];

        int maximum = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > maximum)
                    mas[i][j] = maximum;
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == maximum) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int rowCount = 0;
        for (Boolean value : delRow) {
            if (!value) rowCount++;
        }
        int colCount = 0;
        for (Boolean value : delCol) {
            if (!value) colCount++;
        }

        int[][] res = new int[rowCount][colCount];
        int ir = 0;
        int jr = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jr++] = mas[i][j];
                    }
                }
                ir++;
                jr = 0;
            }
        }

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        return res;
    }
}
