package NowCoder;

import java.util.*;
public class n个数里最小的k个 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            while(sc.hasNextLine()){
                String oneLine = sc.nextLine();
                String[] stringArray = oneLine.split(" ");
                int[] array = new int[stringArray.length];
                int i = 0;
                for(String oneString : stringArray){
                    array[i++] = Integer.parseInt(oneString);
                }
                int k = array[array.length-1];
                fun(array,k);
            }
        }

        private static void fun(int[] array, int k){
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
            for(int i = 0; i < k; i++){
                pq.add(array[i]);
            }
            for(int i = k; i < array.length - 1; i++){
                if(pq.peek() > array[i]){
                    pq.remove();
                    pq.add(array[i]);
                }
            }
            LinkedList<Integer> list = new LinkedList<>();
            while(!pq.isEmpty()){
                list.push(pq.remove());
            }
            while(list.size() > 1){
                System.out.print(list.pop() + " ");
            }
            System.out.println(list.pop());
        }

}
