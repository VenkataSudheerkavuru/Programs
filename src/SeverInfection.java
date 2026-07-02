
public class SeverInfection {
    public static void main(String[] args) {

        int[][] grid = {{1,0,0},{-1,-1,-1},{0,0,0}};
        int min = getMinimumMinutes(grid);
       for(int i = 0;i<3;i++){
           for(int j = 0;j<3;j++){
               if (grid[i][j] == 0) {
                   min = -1;
                   break;
               }
           }
       }
       System.out.print(min);
    }

    public static int getMinimumMinutes(int[][] grid){
        int cols = grid.length;
        int rows = grid[0].length;

        int result = 0;
        int minimum = 0;
        int count =0;

        int[][] temp = new int[3][3];
        copyValues(temp,grid);

        while(true){

            for(int i =0;i<rows;i++){
                for(int j =0;j<cols;j++){
                    if(grid[i][j] == 1){
                        if(i!=0 && i+1!=cols){
                            if(grid[i-1][j] == 0) {
                                temp[i - 1][j] = 1;
                                result++;
                            }
                            if(i<rows && grid[i+1][j] == 0) {
                                temp[i + 1][j] = 1;
                                result ++;
                            }
                        }
                        if(j!=0 && j!=rows){
                            if(grid[i][j-1] == 0){
                                temp[i][j-1] = 1;
                                result++;
                            }
                            if(i+1<rows && j+1<cols && grid[i][j+1] == 0) {
                                temp[i][j + 1] = 1;
                                result++;
                            }
                        }
                        if(i == 0 && i+1<rows && grid[i+1][j] == 0){
                            temp[i+1][j] = 1;
                            result++;
                        }
                        if(j== 0 && j+1 <cols && grid[i][j+1] == 0){
                            temp[i][j+1] =1;
                            result++;
                        }
                        if(i== rows-1 && grid[i-1][j] == 0){
                            temp[i-1][j] = 1;
                            result++;
                        }
                        if(j==cols-1 && grid[i][j-1]==0){
                            temp[i][j-1] = 1;
                            result++;
                        }
                    }

                }
            }
            copyValues(grid,temp);
            if(result == minimum){
                return count;
            }
            count++;
            minimum = result;
        }

    }
    public static void copyValues(int[][] arr1,int[][] arr2){
        for(int i = 0;i<3;i++){
            System.arraycopy(arr2[i], 0, arr1[i], 0, 3);
        }

    }
}