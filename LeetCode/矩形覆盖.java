package NowCoder;

//https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 */
public class 矩形覆盖 {
    public int rectCover(int target) {
        if(target == 1){
            return 1;
        }else if(target < 1){
            return 0;
        }else if(target == 2){
            return 2;
        }else{
            return rectCover(target - 1) + rectCover(target - 2);
        }
    }
}
