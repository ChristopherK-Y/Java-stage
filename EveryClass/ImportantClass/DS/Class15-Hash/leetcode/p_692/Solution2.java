package leetcode.p_692;

import java.util.*;

public class Solution2 {
    static class WordCount implements Comparable<WordCount> {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount o) {
            if (this.count == o.count) {
                // this: i
                // o: love
                // o < this
                return o.word.compareTo(this.word);
            }

            return this.count - o.count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // 1. 先统计各个单词的出现次数
        Map<String, Integer> map = new TreeMap<>();
        for (String w : words) {
            int count = map.getOrDefault(w, 0);
            map.put(w, count + 1);
        }

        // 2. 将所有单词 + 次数组织成线性结构
        List<WordCount> wordCountList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            WordCount wc = new WordCount(word, count);
            wordCountList.add(wc);
        }

        PriorityQueue<WordCount> queue = new PriorityQueue<>();
        for (WordCount wc : wordCountList) {
            if (queue.size() < k) {
                queue.add(wc);
            } else if (wc.compareTo(queue.element()) > 0) {
                queue.remove();
                queue.add(wc);
            }
        }

        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            WordCount wc = queue.remove();
            ans.add(0, wc.word);
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        Solution2 s = new Solution2();
        List<String> ans = s.topKFrequent(words, 2);
        System.out.println(ans);
    }
}
