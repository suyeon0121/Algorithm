import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, day;
    static int[][] arr;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = {-1, 1, 0, 0 };
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        BFS();

        int res = 0;
        for  (int k = 0; k < N; k++) {
            for (int j = 0; j < M; j++) {
                if (arr[k][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                res = Math.max(res, arr[k][j]);
            }
        }
        System.out.println(res-1);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}