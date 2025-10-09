import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int cnt = icecount();

            if (cnt >= 2) {
                System.out.println(year);
                return;
            }

            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            melt();
            year++;
        }
    }

    static int icecount() {
        visit = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && !visit[i][j]) {
                    BFS(i, j, visit);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void BFS(int i, int j, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0], y = tmp[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visit[nx][ny] && arr[nx][ny] > 0) {
                    visit[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    static void melt() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0) {
                    int sea = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                            sea++;
                        }
                    }
                    temp[i][j] = Math.max(arr[i][j] - sea, 0); 
                }
            }
        }
        arr = temp;
    }
}
