package NowCoder;

import java.util.*;

public class 微信红包 {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int mid = n / 2;
        int redPaper = gifts[mid];
        int count = 0;
        for (int i = mid; i < n; i++) {
            if (gifts[i] == redPaper) {
                count++;
            } else {
                break;
            }
        }

        for (int i = mid - 1; i >= 0; i--) {
            if (gifts[i] == redPaper) {
                count++;
            } else {
                break;
            }
        }

        if (count > n / 2) {
            return redPaper;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3, 2, 2};
        System.out.println(new 微信红包().getValue(val,5));
    }
}
