package NowCoder;

import java.util.*;

public class 幸运的袋子 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(fun(array,0,0,1));
    }

    private static int fun(int[] array, int index, int sum, int mul){
        int count = 0;
        for(int i = index; i < array.length; i++){
            sum += array[i];
            mul *= array[i];

            if(sum > mul){//当满足条件的时候，继续往下走
                count += 1 + fun(array,i+1,sum,mul);
            }else if(array[i] == 1){//当不满足条件的时候，如果当时是1，那么将来还有可能有情况的，sum > mul
                count += fun(array,i+1,sum,mul);
            }else{//不满足则，直接退出。
                break;
            }
            //在计算下次之前，先把sum和mul恢复
            sum -= array[i];
            mul /= array[i];
            //去除重复
            while(i < array.length - 1 && array[i] == array[i+1]){
                i++;
            }
        }
        return count;
    }
}
