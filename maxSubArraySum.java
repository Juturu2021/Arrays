/*
  Find the maximum sum of contiguous non-empty subarray within an array A of length N.

  Input 1: A = [1, 2, 3, 4, -10]                     Output1: 10
  Input 2: A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]       Output2: 6

  //total number of subarrays is : n(n+1)/2; = 7(7+1)/2 = 28;
*/
import java.util.*;

//Idea1: brute force idea - T.C = O(n^3) & S.C : O(1)
public class Main {
  public static void main(String[] args) {
      int[] arr = {-2,3,4,-1,5,-10,7};
      int n = arr.length;//7
      
          int ans = 0;
          for(int i=0 ;i<n; i++){
            for(int j=i; j<n; j++){
              int sum = 0;
              for(int k=i; k<=j; k++){
                sum += arr[k];
              }
              ans = Math.max(ans, sum);
            }
          }
          System.out.println(ans);
  }
}
    
//Idea2: Try with Prefix Sum - T.C: O(n^2) S.C : O(n)
public static void main(String[] args) {
  int[] arr = {-2,3,4,-1,5,-10,7};
  int n = arr.length;//7
    int ans =0;
    int[] prefixSumArray = new int[n];
    prefixSumArray[0] = arr[0];
    for(int i=1; i<n; i++){
      prefixSumArray[i] = prefixSumArray[i-1] + arr[i];
    }
    for(int i=0; i<n; i++){
      int sum = 0;
      for(int j=i; j<n; j++){
        if(i==0){
          sum = prefixSumArray[j];
        }
        else{
          sum = prefixSumArray[j] - prefixSumArray[i-1];
        }
        ans = Math.max(ans, sum);
      }
    }
    System.out.println(ans);
  }
}

//Idea 3: using carry forward technique - T.C : O(n^2), S.C : O(1)
public class Main {
  public static void main(String[] args) {
    int[] arr = {-2,3,4,-1,5,-10,7};
    int n = arr.length;//7
    int ans = 0;
    for(int i=0; i<n; i++){
      int sum = 0;
      for(int j=i; j>=0; j--){
        sum += arr[j];
        ans = Math.max(ans, sum);
      }
    }
    System.out.println(ans);
  }
}

//Idea 4: kadan's algorithm:
public class Main {
  public static void main(String[] args) {
    int[] arr = {-2,3,4,-1,5,-10,7};
    int n = arr.length;
    int max_sum = Integer.MIN_VALUE;
    int current_sum = 0;
    for(int i=0; i<n; i++){
      current_sum += arr[i];
      if(current_sum > max_sum){
      max_sum = current_sum;
      }
      if(current_sum < 0){
        current_sum = 0;
      }
    }
    System.out.println(max_sum);
  }
}
