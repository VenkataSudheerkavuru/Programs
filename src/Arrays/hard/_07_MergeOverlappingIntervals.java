package Arrays.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _07_MergeOverlappingIntervals {

    /*
     * Problem:
     * Given an array of intervals where intervals[i] = [starti, endi],
     * merge all overlapping intervals and return an array of the
     * non-overlapping intervals that cover all the intervals.
     *
     * Example:
     *
     * Input :
     * [[1,3],[2,6],[8,10],[15,18]]
     *
     * Output:
     * [[1,6],[8,10],[15,18]]
     *
     * Input :
     * [[1,4],[4,5]]
     *
     * Output:
     * [[1,5]]
     */

    public static int[][] merge_bruteforce(int[][] intervals) {

        // Write your code here
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[][] res = new int[intervals.length][2];
        int k = 0;
        for(int i = 0;i<intervals.length;i++){

            int start = intervals[i][0];
            int end = intervals[i][1];
            if(i!=0 && end <= res[k-1][1]){
                continue;
            }
            for(int j = i+1;j<intervals.length;j++){
                if(intervals[j][0] <= end){
                    end = Math.max(intervals[j][1],end);
                }else{
                    break;
                }
            }
            res[k][0] = start;
            res[k][1] = end;
            k++;

        }

        return Arrays.copyOf(res, k);
    }

    public static int[][] merge(int[][] intervals) {

        // Write your code here
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[][] res = new int[intervals.length][2];
        int k = 0;
        for(int i = 0;i<intervals.length;i++){

            int start = intervals[i][0];
            int end = intervals[i][1];
            if(i == 0){
                res[k][0] = start;
                res[k][1] = end;
                k++;
                continue;
            }
            int prevEnd = res[k-1][1];
            if(start <= prevEnd){
                res[k-1][1] = Math.max(prevEnd,end);
                continue;
            }
            res[k][0] = start;
            res[k][1] = end;
            k++;
        }

        return Arrays.copyOf(res, k);
    }

    private static void test(int[][] intervals, int[][] expected) {

        int[][] result = merge(intervals);

        if (Arrays.deepEquals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("Expected : " + Arrays.deepToString(expected));
            System.out.println("Actual   : " + Arrays.deepToString(result));
        }
    }

    public static void main(String[] args) {

        System.out.println("===== Merge Overlapping Intervals =====");

        test(
                new int[][]{{1,3},{2,6},{8,10},{15,18}},
                new int[][]{{1,6},{8,10},{15,18}}
        );

        test(
                new int[][]{{1,4},{4,5}},
                new int[][]{{1,5}}
        );

        test(
                new int[][]{{1,4}},
                new int[][]{{1,4}}
        );

        test(
                new int[][]{{1,4},{2,3}},
                new int[][]{{1,4}}
        );
    }
}