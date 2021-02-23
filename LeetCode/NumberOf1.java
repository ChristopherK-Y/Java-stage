package NowCoder;

//https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class NumberOf1 {
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);//正好可以去一个1
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberOf1(10));
    }
}
