package LeetCode;

import java.util.ArrayList;

public class CalPoints {
    public int calPoints(String[] ops) {
        ArrayList<Integer> list = new ArrayList<>();
        for (String oneElement : ops) {
            switch (oneElement) {
                case "+":
                    int one = list.get(list.size() - 1);
                    int two = list.get(list.size() - 2);
                    list.add(one + two);
                    break;
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                default:
                    list.add(Integer.parseInt(oneElement));
                    break;
            }
        }
        int sum = 0;
        for (int oneElement : list) {
            sum += oneElement;
        }
        return sum;
    }
}
