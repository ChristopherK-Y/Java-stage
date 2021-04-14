import javax.management.MXBean;

@MyFirstAnnotation
@MXBean
public class AnnotationDemo {
    @MyFirstAnnotation String a;

    @MyFirstAnnotation
    public void method() {
        @MyFirstAnnotation String a = "hello";
    }
}
