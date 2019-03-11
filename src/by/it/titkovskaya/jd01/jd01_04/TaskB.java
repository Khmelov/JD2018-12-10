package by.it.titkovskaya.jd01.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] surnames = new String[n];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < surnames.length; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-------------------------------------------------------");

        int yearSalary =0;
        int totalYearSalary=0;
        for (int k = 0; k < surnames.length; k++) {
            System.out.printf("%-10s",surnames[k]);
            for (int i = k; i==k; i++) {
                for (int j = 0; j < salary[i].length; j++) {
                    yearSalary+=salary[i][j];
                    System.out.printf("%-10d",salary[i][j]);
                }
                totalYearSalary+=yearSalary;
                System.out.printf("%-10d\n",yearSalary);
                yearSalary=0;
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10d\n","Итого",totalYearSalary);
        double averageQuarterSalary=(double)totalYearSalary/(n*4);
        System.out.printf("%-10s%-10.3f","Средняя",averageQuarterSalary);
    }
}
