import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp =  new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = sc.nextInt();
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
            }
        }
        System.out.println(dp[N]);
    }
}