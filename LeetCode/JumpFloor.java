package NowCoder;

//https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class JumpFloor {
    public int jumpFloor(int target) {
        int sum = 0;
        if (target > 2) {
            sum += jumpFloor(target - 1) + jumpFloor(target - 2);
        } else if (target == 1) {
            return 1;
        } else {
            return 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new JumpFloor().jumpFloor(4));
    }
}