package NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/5973a31d58234b068fa1fe34f7290855
 */
public class 收件人列表 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextLine());
            }
            System.out.println(fun(list));
            list.clear();
        }
    }

    private static String fun(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String one : list) {
            if (one.contains(" ") || one.contains(",")) {
                sb.append("\"").append(one).append("\", ");
            } else {
                sb.append(one).append(", ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }
}
