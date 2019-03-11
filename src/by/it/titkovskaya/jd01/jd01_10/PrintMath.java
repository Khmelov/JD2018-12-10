package by.it.titkovskaya.jd01.jd01_10;

import java.lang.reflect.*;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder mm = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                mm.append("public ");
                if (Modifier.isPrivate(modifiers)) mm.append("private ");
                if (Modifier.isProtected(modifiers)) mm.append("protected ");
                if (Modifier.isStatic(modifiers)) mm.append("static ");
                Class<?> returnType = method.getReturnType();
                String ret = returnType.getSimpleName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                StringBuilder paramTypes = new StringBuilder();
                String delimiter = "";
                for (Class<?> parameterType : parameterTypes) {
                    paramTypes.append(delimiter).append(parameterType);
                    delimiter=",";
                }
                System.out.printf("%s%s %s(%s)\n", mm, ret, name, paramTypes);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            System.out.printf("%s %s\n", type.getName(), field.getName());
        }
    }
}
