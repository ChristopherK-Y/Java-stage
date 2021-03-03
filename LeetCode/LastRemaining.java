package NowCoder;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class LastRemaining {
    /**
     * 本方法是模拟了小朋友分礼物的全过程
     * @param n 总共的小朋友个数
     * @param m 当前指定的数字m
     * @return 编号为几的小朋友获得了最终的礼物
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> childList = new ArrayList<>();//此处可以使用LinkedLIst删除节点的效率比较高
        for (int i = 0; i < n; i++) {
            childList.add(i);//每个小朋友的序号，加入顺序表
        }
        int removeIndex = 0;
        while (childList.size() > 1) {//开始
            removeIndex = (removeIndex + m - 1) % childList.size();
            childList.remove(removeIndex);
        }
        return childList.get(0);//返回仅剩的一个小朋友的序号。
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(5, 3));
    }
}
