import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    static int[] next, cnt;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        next = new int[]{U, -D};
        visit = new boolean[F + 1];
        cnt = new int[F + 1];

        BFS(S);

        if (!visit[G]) {
            System.out.println("use the stairs");
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        cnt[start] = 0;

        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (tmp == G) {
                System.out.println(cnt[tmp]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx = tmp + next[i];
                if (nx < 1 || nx > F) continue;
                if (!visit[nx]) {
                    visit[nx] = true;
                    q.offer(nx);
                    cnt[nx] = cnt[tmp] + 1;
                }
            }
        }
    }
}