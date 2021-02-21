//https://leetcode-cn.com/problems/number-of-substrings-with-only-1s/
public class NumSub {
    /**
     * 思路：
     * 核心思路：
     * 如果是连续的k个1，那么他关于1的子集个数是：k*(k+1)/2
     * <<->> 1的个数是k个
     * <<->> 11的个数是k-1个
     * <<->> 111的个数是k-2个 
     * <<->> 1111的个数是k-3个
     * ……
     * <<->> k个1的个数是1个
     * 总和(1+k)*k/2(等差数列)
     */
    public int numSub(String s) {
        long sum = 0;//子集的个数
        int count = 0;//局部1的个数
        for (char oneElement : s.toCharArray()) {
            if (oneElement == '1') {
                count++;//如果是1，那么就局部1++
            } else {
                //当不是1的时候，就使用公式k*（k+1）/ 2计算当前子集的个数
                sum += (long) count * (count + 1) / 2;
                //算完count置0
                count = 0;
            }
        }
        //防止，最后一次，扫描依然是1，就退出了，少计算一次。
        sum += (long) count * (count + 1) / 2;
        //应题目要求进行取模运算
        return (int) (sum % (1000000000 + 7));
    }

    public static void main(String[] args) {
        String newString = "0110111";
        System.out.println(new NumSub().numSub(newString));
    }
}
