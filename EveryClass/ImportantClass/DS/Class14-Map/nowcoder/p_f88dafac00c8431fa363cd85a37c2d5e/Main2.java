package nowcoder.p_f88dafac00c8431fa363cd85a37c2d5e;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
牛客网上的常见问题：
1. 很可能是多组用例的形式提供
2. 英文字母只输出大写
3. 如果实在搞不定输入输出，可以看看别人完成的代码
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ctrl + D 在 IDEA 上终止输入
        while (scanner.hasNextLine()) {
            // 完成一组用例的测试

            String expected = scanner.nextLine().toUpperCase();
            String real = scanner.nextLine().toUpperCase();

            Set<Character> realSet = new TreeSet<>();
            for (char ch : real.toCharArray()) {
                realSet.add(ch);
            }

            Set<Character> outputtedSet = new TreeSet<>();
            for (char ch : expected.toCharArray()) {
                if (!realSet.contains(ch) && !outputtedSet.contains(ch)) {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}
