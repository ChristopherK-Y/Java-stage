package use_map;

import java.util.Map;
import java.util.TreeMap;

public class Demo1 {
    public static void main(String[] args) {
        String s = "i love java you love java";
        String[] wordArray = s.split(" ");
        Map<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : wordArray) {
            int count = wordCountMap.getOrDefault(word, 0);
            wordCountMap.put(word, count + 1);
//            if (!wordCountMap.containsKey(word)) {
//                wordCountMap.put(word, 1);
//            } else {
//                int count = wordCountMap.get(word);
//                wordCountMap.put(word, count + 1);
//            }
        }
        System.out.println(wordCountMap);

        // 统计每个单词出现的次数 -> Map<单词 String, 次数 Integer>
    }
}
