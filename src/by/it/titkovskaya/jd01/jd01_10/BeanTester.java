package by.it.titkovskaya.jd01.jd01_10;
/*
TaskC1. Создайте класс BeanTester который в методе main с сигнатурой, допускающей Exception:
public static void main(String[] args) throws Exception создает экземпляр класса Bean (оператор
new Bean( ) для этого использовать нельзя!), а затем находит и запускает его методы,
помеченные созданной аннотацией с указанными в ней параметрами a и b. После каждого вызова
invoke на консоль выводится имя найденного метода и результат запуска.
 */

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        Object instance = beanClass.getDeclaredConstructor().newInstance();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)){
                System.out.printf("%s %s\n", declaredMethod.getName(),
                        declaredMethod.invoke(instance,
                                declaredMethod.getAnnotation(Param.class).a(),
                                declaredMethod.getAnnotation(Param.class).b()));
            }
        }
    }
}
