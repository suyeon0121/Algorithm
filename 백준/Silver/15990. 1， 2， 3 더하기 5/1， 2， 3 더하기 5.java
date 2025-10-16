import java.io.*;

public class Main {
    static int t, n;
    static final int MOD = 1_000_000_009;
    static long[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        num = new long[100_001][4];
        num[1][1] = 1;
        num[2][2] = 1;
        num[3][1] = 1;
        num[3][2] = 1;
        num[3][3] = 1;

        for (int i = 4; i < 100_001; i++) {
            num[i][1] = (num[i - 1][2] + num[i - 1][3]) % MOD;
            num[i][2] = (num[i - 2][1] + num[i - 2][3]) % MOD;
            num[i][3] = (num[i - 3][1] + num[i - 3][2]) % MOD;
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            long res = (num[n][1] + num[n][2] + num[n][3]) % MOD;
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}