package by.it.yarmolenka.jd02_04.MathCalc.Variables;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    public double[][] value;

    public Matrix(double[][] array) {
        this.value = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++)
            System.arraycopy(array[i], 0, this.value[i], 0, array[i].length);
    }

    public Matrix(Matrix mat) {
        this.value = new double[mat.value.length][mat.value[0].length];
        for (int i = 0; i < mat.value.length; i++)
            System.arraycopy(mat.value[i], 0, this.value[i], 0, mat.value[i].length);
    }

    public Matrix(String s) {

        //Убираем .0 и разделяем строку на одномерные массивы
        s = s.replace(".0", "");
        Pattern pt = Pattern.compile("[{][0-9., -]+[}]");
        Matcher m1 = pt.matcher(s);
        ArrayList<String> list = new ArrayList<>();
        while (m1.find()) list.add(m1.group());

        //выясняем количество членов в одномерных массивах и задаём размеры матрице this
        String[] buf = list.get(0).split(",");
        this.value = new double[list.size()][buf.length];

        //убираем лишние символы из одномерных массивов и переносим данные в матрицу this
        for (int i = 0; i < list.size(); i++) {
            String buff = list.get(i).replace("{", "");
            buff = buff.replace("}", "");
            String[] str = buff.split(",");
            for (int j = 0; j < str.length; j++) {
                this.value[i][j] = Double.parseDouble(str[j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder del = new StringBuilder(", ");
        for (int i = 0; i < this.value.length; i++) {
            sb.append("{").append(this.value[i][0]);
            for (int j = 1; j < this.value[i].length; j++)
                sb.append(del).append(this.value[i][j]);
            sb.append("}");
            if (i < this.value.length - 1) sb.append(del);
        }
        sb.append("}");
        return sb.toString();
    }
}
