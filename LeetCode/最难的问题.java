package NowCoder;

import java.util.*;
//https://www.nowcoder.com/questionTerminal/9f6b8f6ec26d44cfb8fc8c664b0edb6b
public class 最难的问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String in = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (char oneChar : in.toCharArray()) {
                if (oneChar == ' ') {//如果是空格直接+
                    sb.append(" ");
                    continue;
                }
                //如果不是,那么就往回退5个位置(+21 == -5+26)
                sb.append((char) (oneChar - 5 >= 'A' ? oneChar - 5 : oneChar + 21));
            }
            System.out.println(sb);
        }
    }
}
