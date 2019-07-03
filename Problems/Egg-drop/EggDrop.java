class EggDrop {
    //for n floors and k eggs
    //Recursion was f(n, k) = 1 + min(cur_min, max(f(i, k - 1), f(n - i, k)))
    //Base cases: f(n, 1) = n, f(0, 0) = 0, f(0, 1) = 0, f(1, 0) = 0

    private int n;
    private int k;
    private int[][] dp;

    EggDrop(int floors, int eggs) {
        n = floors;
        k = eggs;
        dp = new int[1000][1000];
    }

    public int solve(){
        for(int i = 0; i <= n; ++i) {
            for(int j = 0; j <= k; ++j) {
                if(i == 0 || i == 1) {
                    dp[i][j] = 0;
                } else if (j == 1) {
                    dp[i][j] = i;
                } else if (j == 0) {
                    //impossible
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    int cur_min = Integer.MAX_VALUE;
                    for(int x = 1; x < i; x++){
                        cur_min = Math.min(cur_min, 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                    }
                    dp[i][j] = cur_min;
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        EggDrop prob = new EggDrop(100, 2); 
        System.out.println(prob.solve());
    }
}
