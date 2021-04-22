package NowCoder;

import java.util.*;

//https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a

/**
 *          top →
 *          ******
 *   ↑ left ****** right ↓
 *          ******
 *          ← low
 *
 * 先 top → , 然后 right ↓ , 然后是 ← low , 最后 ↑ left , 不断循环.
 *    top++       right--          low--       left++
 */
public class 顺序打印矩阵 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int top = 0;
        int low = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while(top <= low && left <= right){
            for(int i = left; i <= right; i++){//top →
                list.add(matrix[top][i]);
            }
            top++;

            if(top > low || left > right){
                break;
            }

            for(int i = top; i <= low; i++){//right ↓
                list.add(matrix[i][right]);
            }
            right--;

            if(top > low || left > right){
                break;
            }

            for(int i = right; i >= left; i--){//← low
                list.add(matrix[low][i]);
            }
            low--;

            if(top > low || left > right){
                break;
            }

            for(int i = low; i >= top; i--){//↑ left
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
