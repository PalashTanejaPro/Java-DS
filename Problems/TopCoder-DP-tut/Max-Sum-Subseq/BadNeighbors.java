import java.util.Arrays;

public class BadNeighbors {

    public int solve(int[] donations) {
        // int[] dp = new int[41]; 
        // Boolean[] hasFirstElement = new Boolean[41];
        // for(int i = 0; i < 41; ++i) hasFirstElement[i] = false;
        // hasFirstElement[0] = true; 
        //dp(i): max valued subsequence with a[i] as its end element
        //dp(i) = a[i] + max(dp[i-1 ... 0]) unless i == n in which case n-1 ... 1
        //base case: dp(0) = a[0]

        int n = donations.length; 
        int cur_max = 0; 
        int dp = 0;
        int prev_dp = 0;
        int ret = 0;  
        for(int i = 0; i < n; ++i) {
            if (i == 0) {
                prev_dp = donations[0];
                ret = Math.max(prev_dp, ret);
            } else {
                dp = cur_max + donations[i];
                cur_max = Math.max(cur_max, prev_dp);
                prev_dp = dp;
                ret = Math.max(dp, ret); 
            }
        }
        
        return ret;
    }

    public int maxDonations(int[] donations) {
        if (donations.length == 1) return donations[0];

        return Math.max(solve(Arrays.copyOfRange(donations, 1, donations.length)), solve(Arrays.copyOfRange(donations, 0, donations.length - 1)));
    }

    public static void main(String[] args) {
        BadNeighbors test = new BadNeighbors();
        int[] testData =     	
        { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
          6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
          52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
        System.out.println(test.maxDonations(testData));
    }
}