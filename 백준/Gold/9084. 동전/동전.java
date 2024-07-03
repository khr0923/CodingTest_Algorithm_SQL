import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] coins = new int[N + 1];


            for(int j = 1; j <= N; j++) {
                coins[j] = sc.nextInt();
            }

            int M = sc.nextInt();
            int[] dp = new int[M + 1];

            for(int k = 1; k <= N; k++) {
                for (int l = 1; l <= M; l++) {
                    if(l - coins[k] > 0) {
                        dp[l] = dp[l] + dp[l-coins[k]];
                    } else if(l - coins[k] == 0) {
                        dp[l]++;
                    }
                }
            }

            sb.append(dp[M] + "\n");
        }
        System.out.println(sb);
    }
}
