//编写一个程序判断给定的数是否为丑数。
//丑数就是只包含质因数2, 3, 5的正整数。
//示例 1:
//输入: 6
//输出: true
//解释: 6 = 2 × 3
//
//示例 2:
//输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
//
//示例3:
//输入: 14
//输出: false
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。
//说明：
//
//1是丑数。
//输入不会超过 32 位有符号整数的范围:[−2^31, 2^31− 1]。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/ugly-number
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


/**
 * 功能：判断一个数是否是丑数
 * 返回值：boolean
 * 参数：一个int类型的整数
 *
 * 思路：如果一个数是丑数，那么不断的给它除2，3，5除到最后，就一定剩下一个1了
 * 如果这个数字不是一个丑数，那么它最后一定除不到1，例如14=2*7,最后就会除到7
 * 如果最后在最后函数还没有返回，那么它就不是一个丑数
 */
public class Ugly_263 {
    public static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num % 2 == 0) {
            num /= 2;
            if (num == 1) {
                return true;
            }
        }
        while (num % 3 == 0) {
            num /= 3;
            if (num == 1) {
                return true;
            }
        }
        while (num % 5 == 0) {
            num /= 5;
            if (num == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}
