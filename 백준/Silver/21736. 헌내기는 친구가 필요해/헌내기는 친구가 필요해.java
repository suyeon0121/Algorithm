import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt = 0;
    static char[][] campus;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine().toCharArray();
            if(q.isEmpty()) {
                for(int j = 0; j < M; j++) {
                    if (campus[i][j] == 'I') {
                        q.addLast(new int[]{i, j});
                        break;
                    }
                }
            }
        }
        bfs();
        System.out.println(cnt > 0 ? cnt : "TT");
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[]tem = q.removeFirst();
            int x = tem[0], y = tem[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (campus[nx][ny] != 'X' && visit[nx][ny] == 0) {
                    if (campus[nx][ny] == 'P') {
                        cnt++;
                    }
                    visit[nx][ny] = 1;
                    q.addLast(new int[]{nx, ny});
                }
            }
        }
    }
}