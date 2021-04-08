package leetcode.p771;

import java.util.TreeSet;

class Solution {                 // m           n
    public int numJewelsInStones(String jewels, String stones) {
        // 把宝石转成 set 形式
        // Character 实现了 Comparable
        TreeSet<Character> set = new TreeSet<>();

        // O(m)
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }

        int count = 0;
        // O(n)
        for (char stone : stones.toCharArray()) {
            // O(log(m))
            if (set.contains(stone)) {
                count++;
            }
        }

        return count;
    }
}
