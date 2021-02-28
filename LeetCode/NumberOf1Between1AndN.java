package NowCoder;

//https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class NumberOf1Between1AndN {
    public int numberOf1Between1AndN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            int count = 0;
            while (number != 0) {
                if (number % 10 == 1) {
                    count++;
                }
                number /= 10;
            }
            sum += count;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().numberOf1Between1AndN(13));
    }
}
