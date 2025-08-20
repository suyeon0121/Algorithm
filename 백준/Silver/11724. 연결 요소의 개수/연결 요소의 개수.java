import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, u, v;
    static int[][] arr;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken())-1;
            v = Integer.parseInt(st.nextToken())-1;
            arr[u][v] = arr[v][u] = 1;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i = 0; i < N; i++) {
                if (!visited[i] && arr[n][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}