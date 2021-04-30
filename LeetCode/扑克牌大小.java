package NowCoder;
import java.util.*;

//https://www.nowcoder.com/questionTerminal/0a92c75f5d6b4db28fcfa3e65e5c9b3f
public class 扑克牌大小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("3", 0); 
        map.put("4", 1);
        map.put("5", 2);
        map.put("6", 3);
        map.put("7", 4);
        map.put("8", 5);
        map.put("9", 6);
        map.put("10", 7);
        map.put("J", 8);
        map.put("Q", 9);
        map.put("K", 10);
        map.put("A", 11);
        map.put("2", 12);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String left = str.split("-")[0];
            String[] lefts = left.split(" ");
            String right = str.split("-")[1];
            String[] rights = right.split(" ");
            if (left.equals("joker JOKER") || right.equals("joker JOKER")) {//谁有对王，谁就赢了
                System.out.println("joker JOKER");
            } else if (lefts.length == 4 && rights.length != 4) {//谁有炸弹，谁就赢了
                System.out.println(left);
            } else if (lefts.length != 4 && rights.length == 4) {//谁有炸弹，谁就赢了
                System.out.println(right);
            } else if (lefts.length != rights.length) {//此时，牌数必须相同，不同就无法比较
                System.out.println("ERROR");
            } else if (map.get(lefts[0]) > map.get(rights[0])) {//此时会有个子，对子，顺子，三个，炸弹，比较开头就好了
                System.out.println(left);
            } else {
                System.out.println(right);
            }
        }
    }
}
