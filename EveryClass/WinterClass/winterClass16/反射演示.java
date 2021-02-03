import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

// 1. 运行期
// 2. 运行期感知到类中代码的能力
public class 反射演示 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 1. 获取类对象的表达
        Class aClass = String.class;   // 通过类名获取
        Class bClass = "hello".getClass();    // 通过对象获取
        Class cClass = Class.forName("java.lang.String");   // 通过完整的类名获取

        // aClass 和 bClass 这里都是引用
        // 指向的是一类特殊的对象 —— 属于 “类” 自己的对象
        System.out.println(aClass == bClass);
        System.out.println(bClass == cClass);

        // Class 具备的能力
        // 通过 Class 获取到这个 Class 所代表的类的能力
        // 以下代码的运行是发生在运行期间
        // 体现了反射：运行期间，感知到类的各项功能的能力
        System.out.println(aClass.getName());
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            String[] array = new String[1000];
            Parameter[] parameters = method.getParameters();
            int i = 0;
            for (Parameter parameter : parameters) {
                array[i++] = parameter.getType().getName();
            }
            String parameterString = String.join(", ", Arrays.copyOf(array, i));
            System.out.printf("%s(%s)\n", method.getName(), parameterString);
        }

        // 通过 Class 可以实例化对象
        Object o = aClass.newInstance();
        String p = new String();
        System.out.println(o.getClass().getName());
    }
}
