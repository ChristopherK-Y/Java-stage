import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
1. 存在于哪个时期
Source/Class/Runtime
 */
@Retention(RetentionPolicy.RUNTIME)
/*
2. 可以修饰什么
 */
@Target( value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.LOCAL_VARIABLE})
public @interface MyFirstAnnotation {
}
