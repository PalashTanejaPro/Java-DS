import java.util.Scanner;

class ShortestPath {

    private int[][] graph;
    private int[] dp;
    private Boolean[] visited; 
    private int vertices; 
    //DP(i) state: shortest distance from Vertex 1 to Vertex i
    //Therefore for a new vertex n, DP(n) = min(DP(all_neighbors_of_n))

    ShortestPath() {
        graph = new int[1000][1000];
        dp = new int[1000];
        visited = new Boolean[1000];

        for(int i = 0; i < 1000; ++i) dp[i] = Integer.MAX_VALUE;
        dp[1] = 0; //base case
    } 
    //for all k neighbors of 1, dp[1] = graph[1][k]
    
    public void input() {
        System.out.println("What's the number of vertices?");
        Scanner sc = new Scanner(System.in);
        vertices = sc.nextInt();

        for(int i = 0; i < vertices; ++i) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            int val = sc.nextInt();

            graph[source][dest] = val; 
        }

        sc.close();
    }

    public int solve(int N) {
        for(int i = 1; i <= vertices; i++) {
            for(int j = 1; j <= vertices; j++) {
                if(graph[i][j] != 0){
                    //i and j are connected
                    dp[j] = Math.min(dp[j], dp[i] + graph[i][j]);
                }   
            }
            visited[i] = true; 
        }

        return dp[N];
    }

    public static void main(String[] args) {
        ShortestPath test = new ShortestPath();
        test.input();
        System.out.println(test.solve(3));
    }
}   