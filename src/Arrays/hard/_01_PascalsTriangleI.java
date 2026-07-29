package Arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class _01_PascalsTriangleI {

    /*
     * Problem:
     * Given row and column (1-indexed), return the element present at
     * that position in Pascal's Triangle.
     *
     * Example:
     * Input:
     * row = 5, col = 3
     *
     *               1
                  1     1
               1    2     1
            1    3     3     1
         1    4     6     4     1
      1    5    10    10     5     1
   1    6    15    20    15     6     1
   *
   * r5c3 = r4c2+r4c3 = 3 + 3 = 6
   * r4c3 = r3c2 + r3c3 = 2 + 1 = 3
   * r4c2 = r3c1 + r3c2 = 1 + 2 = 3
   * r3c1 = 1
   * r3c2 = r2c1 + r2c2 = 1 + 1 = 2
   * r2c1 = 1 (if c is 1 )
   * r2c2 = 1 (if r and c are same )
     * Output:
     * 6
     */

    public static int pascalElement(int row, int col) {

        if (col == 1 || row == col) {
            return 1;
        }

        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        currentRow.add(1);

        while (currentRow.size() < row) {

            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);

            for (int i = 1; i < currentRow.size(); i++) {
                nextRow.add(currentRow.get(i - 1) + currentRow.get(i));
            }

            nextRow.add(1);
            currentRow = nextRow;
        }

        return currentRow.get(col - 1);
    }

    public static int recur(int row,int col){
        if(row == col){
            return 1;
        }
        if(col == 1){
            return 1;
        }
        return recur(row-1,col-1) + recur(row-1,col);
    }

    private static void test(int row, int col, int expected) {

        int result = pascalElement(row, col);

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + result);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Pascal's Triangle I =====");

        test(1, 1, 1);
        test(2, 1, 1);
        test(2, 2, 1);
        test(3, 2, 2);
        test(4, 2, 3);
        test(5, 3, 6);
        test(6, 4, 10);
        test(7, 3, 15);
        test(8, 5, 35);

    }
}