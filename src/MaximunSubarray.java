import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MaximunSubarray {
    public static int maxSubArray(int[] nums) {
        int dp[] = new int [nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String args[]){
        int [] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(a));
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        Integer.
    }
}
