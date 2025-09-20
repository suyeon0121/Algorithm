import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] arr;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        for  (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                    if (arr[h][n][m] == 1) {
                        q.offer(new int[] {h, n, m});
                    }
                }
            }
        }

        BFS();

        int res = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res, arr[h][n][m]);
                }
            }
        }
        System.out.println(res - 1);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int z = now[0], y = now[1], x = now[2];
            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (arr[nz][ny][nx] == 0) {
                        arr[nz][ny][nx] = arr[z][y][x] + 1;
                        q.offer(new int[] {nz, ny, nx});
                    }
                }
            }
        }
    }
}  

