import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, M, N, K, cnt;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T= Integer.parseInt(st.nextToken());

        for  (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            visit = new boolean[M][N];
            cnt = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int k = 0; k < N; k++) {
                for (int h = 0; h < M; h++) {
                    if (arr[h][k] == 1 && !visit[h][k]) {
                        BFS(h, k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void BFS(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visit[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N &&  !visit[nx][ny] && arr[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}