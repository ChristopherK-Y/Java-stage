import java.util.Arrays;
import static java.util.Arrays.*;
import static java.lang.Math.*;

// 通过静态导入后，可以不用类名直接使用导入类中的静态方法和属性
public class 使用静态导入 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };

        System.out.println(Arrays.toString(a));
        sort(a);
        fill(a, 10);

        System.out.println(PI);
    }
}
