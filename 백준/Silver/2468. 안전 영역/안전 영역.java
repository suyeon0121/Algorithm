import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int higt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > higt) higt = arr[i][j];
            }
        }

        int max = 0;
        for (int j = 0; j < higt; j++ ) {
            visit = new boolean[N][N];
            int cnt = 0;
            for (int k = 0; k < N; k++) {
                for (int h = 0; h < N; h++) {
                    if (!visit[k][h] && arr[k][h] > j) {
                        cnt += DFS(k, h, j);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static int DFS(int x, int y, int height) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && arr[nx][ny] > height) {
                DFS(nx, ny, height);
            }
        }
        return 1;
    }
}