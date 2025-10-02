import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int res = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];

        BFS(N, K);

        System.out.println(res);
    }

    public static void BFS(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visit[start] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int pos = now[0];
            int time = now[1];
            if (pos == target) {
                res = time;
                return;
            }

            int[] direction = {pos + 1, pos - 1, pos * 2};
            for (int d : direction) {
                if (d >= 0 && d < 100001 && !visit[d]) {
                    q.offer(new int[]{d, time + 1});
                    visit[d] = true;
                }
            }
        }
    }
}