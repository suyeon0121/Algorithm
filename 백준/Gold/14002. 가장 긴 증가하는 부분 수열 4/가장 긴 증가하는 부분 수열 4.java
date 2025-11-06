import java.io.*;
import java.util.*;

public class Main {
    static int arr[];
    static Integer dp[];
    static int prev[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new Integer[N];
        prev = new int[N];
        Arrays.fill(prev, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        int last = 0;
        for (int i = 1; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                last = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (last != -1) {
            list.add(arr[last]);
            last = prev[last];
        }
        Collections.reverse(list);

        System.out.println(max);
        for (int n : list) System.out.print(n + " ");
    }

    static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n-1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    if (dp[n] < LIS(i)+1) {
                        dp[n] = LIS(i)+1;
                        prev[n] = i;
                    }
                }
            }
        }
        return dp[n];
    }
}