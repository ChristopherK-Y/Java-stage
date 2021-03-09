package NowCoder;

//https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class ReverseSentence {
    public String reverseSentence(String str) {
        if(str.trim().equals("")){//如果这个字符串全部都是空格，那么直接返回该字符串就好了
            return str;
        }
        String[] array = str.split(" ");//按空格把每一个单词都分开
        StringBuilder ans = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            ans.append(array[i]).append(" ");//倒着加进去，就是正序了
        }
        return new String(ans).trim();//最后把最后一个多余的空格去掉就好了
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSentence().reverseSentence("   "));
    }
}
