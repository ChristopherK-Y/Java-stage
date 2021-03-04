package NowCoder;

//https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class Find {
    /**
     * 思路：
     * 数组的左下角，向右是逐渐递增，向上是逐渐递减
     * 可以想象为，x，y坐标轴
     * y^
     *  | * * * * * * * * * * * *
     *  | * * * * * * * * * * * *
     *  | * * * * * * * * * * * *
     *  | * * * * * * * * * * * *
     *  | * * * * * * * * * * * *
     *----------------------------->x
     *  |
     *  |
     * @param target 要查找的目标值
     * @param array 给定的二维数组
     * @return true/false 找到/找不到
     */
    public boolean find(int target, int[][] array) {
        try {
            //初始化x和y为左下角坐标
            int y = array.length - 1;
            int x = 0;
            while (true) {//死循环
                int nowElement = array[y][x];
                if (nowElement > target) {//如果当前元素比target大，那么y--
                    y--;
                } else if (nowElement < target) {//如果当前元素比target小，那么x++
                    x++;
                } else {//相等返回true
                    return true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {//如果try块发生数组越界异常，那么一定是不存在target，返回false
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(new Find().find(2, array));
    }
}
