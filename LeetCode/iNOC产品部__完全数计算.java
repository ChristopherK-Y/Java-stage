package NowCoder;

import java.util.*;

public class iNOC产品部__完全数计算 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int x = sc.nextInt();
            System.out.println(count(x));
        }
    }

    public static int count(int n){
        int ans = 0;
        for(int i = 2; i <= n; i++){
            if(yue(i) == i){
                ans++;
            }
        }
        if(ans == 0){
            return -1;
        }
        return ans;
    }

    private static long yue(int x){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0){
                list.add(i);
                list.add(x/i);
            }
        }
        long sum = 0;
        for(int oneYue : list){
            sum += oneYue;
        }
        return sum;
    }
}
