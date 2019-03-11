package by.it.titkovskaya.jd01.jd01_12;

import java.util.*;

/*
TaskC3. В консоль вводится строка, состоящая из выражений и символов «(», «)»,
«[», «]», «{», «}».
 Проверьте и выведите в консоль корректность расстановки скобок
(true или false) с помощью коллекций.
 */
public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(check(line));
    }

    private static boolean check(String line) {
        char[] brackets = line.replaceAll("[^{}()\\[\\]]+", "").toCharArray();
        List<Character> openBrackets = new ArrayList<>(Arrays.asList('[','{','('));
        LinkedList<Character> stack = new LinkedList<>();
        for(char bracket : brackets ){
            if(openBrackets.contains(bracket)){
                switch (bracket){
                    case '[': stack.addLast(']'); break;
                    case '{': stack.addLast('}'); break;
                    case '(': stack.addLast(')'); break;
                }
            } else {
                if(stack.isEmpty()){
                    return false;
                } else if (!stack.peekLast().equals(bracket)){
                    return false;
                }
                stack.removeLast();
            }
        }
        return stack.isEmpty();
    }
}


/*

        char[] chars = line.toCharArray();
        Stack<Character> stack = new Stack<>();

char[] brackets = line.replaceAll("[^{}()\\[\\]]+", "").toCharArray();
List<Character> openBrackets = new ArrayList<>(Arrays.asList('[','{','('));
        List<Character> stack = new LinkedList<>();
        for (char bracket : brackets) {
            if (openBrackets.contains(bracket)){
                stack.add(bracket);
            }
            else if (!openBrackets.contains(bracket)){
                if (!stack.isEmpty()&&openBrackets.get())
            }
        }

 */