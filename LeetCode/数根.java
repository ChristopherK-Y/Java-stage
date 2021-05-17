package NowCoder;

import java.util.*;

public class 数根 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int x = sc.nextInt();
            System.out.println(fun(x));
        }
    }

    private static int fun(int x){
        if(String.valueOf(x).length()>1){
            int sum = 0;
            while(x != 0){
                sum += x % 10;
                x /= 10;
            }
            return fun(sum);
        }else{
            return x;
        }
    }
}
