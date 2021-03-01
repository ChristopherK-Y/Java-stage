package NowCoder;

//https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class CutRope {
    /**
     * 首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
     * 当然也可能有4，但是4=2*2，我们就简单些不考虑了。
     * 5<2*3,6<3*3,比6更大的数字我们就更不用考虑了，肯定要继续分。
     * 其次看2和3的数量，2的数量肯定小于3个，为什么呢？因为2*2*2<3*3，那么题目就简单了。
     * 直接用n除以3，根据得到的余数判断是一个2还是两个2还是没有2就行了。
     * 由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
     */
    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        int remainder = target % 3;
        int three = target / 3;
        if (remainder == 0) {
            return (int) Math.pow(3, three);
        } else if (remainder == 1) {
            return 2 * 2 * (int) Math.pow(3, three - 1);
        } else {
            return 2 * (int) Math.pow(3, three);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(7));
    }
}
