package NowCoder;

import java.util.Arrays;

//https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);//首先进行排序，方便以后遍历找数
        int countOfKing = 0;//统计扑克牌中的大小王的个数
        int nowNumber = 0;//记录当前已有的排的面值
        for (int i = 0; i < numbers.length; i++) {
            int nowPoker = numbers[i];
            if (nowPoker == 0) {//如果是大小王，那么countOfKing++;
                countOfKing++;
            } else {//说明是普通排
                if (nowNumber == 0) {//此if只会运行一次，初始化，第一张排为王，但是第一张几乎不可能为王（全是王的情况另说）
                    nowNumber = nowPoker;
                } else {
                    if (nowPoker != nowNumber + 1) {//如果当前扫描的牌的大小不是记录大小的下一个数，那么就要看有王没有了
                        if (countOfKing > 0) {//有王的话王-1，更新当前数字的大小，并且让i--（循环中会有i++，这样下次循环，就还是从这张牌开始）
                            countOfKing--;
                            nowNumber++;
                            i--;
                        } else {//没王，无法替换，所以不是顺子
                            return false;
                        }
                    } else {//满足顺子要求，更新数字
                        nowNumber++;
                    }
                }
            }
        }//循环结束，还没有返回false，说明就是顺子，或者全是王（也是顺子），返回true
        return true;
    }

    public static void main(String[] args) {
        int[] pokerArray = {0, 0, 0, 0, 5};
        System.out.println(new IsContinuous().isContinuous(pokerArray));
    }
}
