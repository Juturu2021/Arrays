public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int n = A*A;
        int i=0, j=0;
        int num=1, k=1;

        while(k<n){
            for(int s=1; s<A; s++){
                result[i][j] = num;
                j++;
                num++;
                k++;
            }
            for(int s=1; s<A; s++){
                result[i][j] = num;
                i++;
                num++;
                k++;
            }
            for(int s=1; s<A; s++){
                result[i][j] = num;
                j--;
                num++;
                k++;
            }
            for(int s=1; s<A; s++){
                result[i][j] = num;
                i--;
                num++;
                k++;
            }
            i++;j++;
            A= A-2;
        }
        if(k==n){
            result[i][j] = num;
        }
        return result;
    }
}
