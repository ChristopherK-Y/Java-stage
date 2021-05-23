package NowCoder;

import java.util.*;

//https://www.nowcoder.com/questionTerminal/0f6976af36324f8bab1ea61e9e826ef5
public class 分解因数 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int x = sc.nextInt();
            System.out.println(format(x,fun(x)));
        }
    }

    private static List<Integer> fun(int x){
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= Math.sqrt(x); i++){
            while(x % i == 0){
                x /= i;
                list.add(i);
            }
            if(x == 1){
                break;
            }
        }
        if(x != 1){
            list.add(x);
        }
        return list;
    }

    private static String format(int x, List<Integer> list){
        StringBuilder sb = new StringBuilder(x+" = ");
        for(int oneNumber : list){
            sb.append(oneNumber).append(" * ");
        }
        return sb.subSequence(0,sb.length()-3).toString();
    }
}
