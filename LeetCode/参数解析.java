package NowCoder;

import java.util.LinkedList;
import java.util.Scanner;

public class 参数解析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String oneLine = sc.nextLine();
            String[] array = oneLine.split(" ");
            LinkedList<String> list = new LinkedList<>();
            for (int i = 0; i < array.length; i++) {
                if (array[i].charAt(0) != '"') {
                    list.add(array[i]);
                    continue;
                } else if (array[i].charAt(0) == '"' && array[i].charAt(array[i].length() - 1) == '"') {
                    String s = array[i].substring(1, array[i].length() - 1);
                    list.add(s);
                    continue;
                }
                StringBuilder sb = new StringBuilder();
                String s = array[i++].substring(1);
                sb.append(s + " ");
                while (array[i].charAt(array[i].length() - 1) != '"') {
                    sb.append(array[i++] + " ");
                }
                s = array[i].substring(0, array[i].length() - 1);
                sb.append(s);
                list.add(sb.toString());
            }
            System.out.println(list.size());
            for (String one : list) {
                System.out.println(one);
            }
        }
    }
}
//xcopy /s "C:\program files" "d:\"
