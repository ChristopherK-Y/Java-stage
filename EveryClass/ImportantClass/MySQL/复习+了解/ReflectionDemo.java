import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = "java.lang.String";
        className = "AnnotationDemo";

        Class clazz = Class.forName(className);
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
