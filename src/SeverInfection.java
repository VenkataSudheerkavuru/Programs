public class SeverInfection {
    public static void main(String[] args) {
//        int[][] grid = {{1, 0, -1}, {0, -1, 0}, {-1, 0, 0}};
        int[][] grid = {{1,-1,-1}};

        int res = getMinimumMinutes(grid);
        System.out.println("result" + res);
    }

    static int getMinimumMinutes(int[][] grid) {

        int count = 0;
        int newCount = 0;
        int[][] temp = new int[grid[0].length][grid.length];
        int minimum = 0;

        while (true) {
            copyArray(grid, temp);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {

                    if (grid[i][j] == 0) {
                        if ((i != 0 && grid[i - 1][j] == 1)
                                || (j != 0 && grid[i][j - 1] == 1)
                                || (i+1 != grid.length && grid[i + 1][j] == 1)
                                || (j+1 != grid.length && grid[i][j + 1] == 1)) {
                            temp[i][j] = 1;
                            count ++;
                        }
                    }

                }
            }
            if (count == newCount) {
                return checkANyleft(grid,minimum);
            }
            copyArray(temp, grid);
            minimum ++;
            newCount = count;
        }
    }
    public static int checkANyleft(int[][] grid,int min) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (ints[j] == -1) {
                    return -1;
                }
            }
        }
        return min;
    }


    //copy arr1 to arr2
    public static void copyArray(int[][] a1, int[][] a2) {
        for (int i = 0; i < a1.length; i++) {
            System.arraycopy(a1[i], 0, a2[i], 0, a1.length);
        }
    }

    public void display(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }
}