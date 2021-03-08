package NowCoder.字节跳动2019春招研发部分编程题汇总;

import java.util.Scanner;

//https://www.nowcoder.com/test/question/42852fd7045c442192fa89404ab42e92?pid=16516564&tid=41711071
public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfString = sc.nextInt();
        for (int i = 0; i < numberOfString; i++) {
            String oneString = sc.next();
            if (oneString.length() <= 3) {//如果一个字符串的长度小于等于3，那么直接输出这个就好了
                System.out.println(oneString);
            }
            StringBuilder sb = new StringBuilder(oneString);//将该单词（String）转换为StringBuilder
            for (int j = 2; j < sb.length(); j++) {//***直接从第三个字母开始
                if (sb.charAt(j - 2) == sb.charAt(j - 1)) {//如果这个字母的，前2个字母相等，那么就是直接有了2个字母相等
                    if (sb.charAt(j) == sb.charAt(j - 1)) {//3个字母相等，删掉当前的这个字母，且j--（因为循环结束要j++）
                        sb.deleteCharAt(j);
                        j--;
                    } else {//走到这里是，2个相等，一个不合他们相等（例如AAB-----）
                        if (j + 1 < sb.length() && sb.charAt(j) == sb.charAt(j + 1)) {//如果为（AABB---），那么删掉当前，同样j--
                            sb.deleteCharAt(j);
                            j--;
                        }
                    }
                }
            }
            //每处理完一个就输出一个
            System.out.println(sb.toString());
        }
    }
}
