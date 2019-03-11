package by.it.titkovskaya.jd01.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var1 = new Scalar(5);
        Scalar var2 = new Scalar(var1);
        Var var3 = new Scalar("222");
        System.out.println("var1=" + var1);
        System.out.println("var2=" + var2);
        System.out.println("var3=" + var3);

        double[] test = {1.0, 2.0, 4.0};
        Vector vec1 = new Vector(test);
        Vector vec2 = new Vector("{1.0, 2.0, 4.0}");
        Vector vec3 = new Vector(vec1);

        System.out.println(vec1);
        System.out.println(vec2);
        System.out.println(vec3);

        double[][] test2 = {{1, 2, 3},{3, 4, 5}};
        Matrix matrix1 = new Matrix(test2);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix("{{1, 2, 3},{3, 4, 5},{6,7,8}}");

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }
}
