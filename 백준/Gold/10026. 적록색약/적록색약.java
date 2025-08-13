import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char arr[][];
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0}; // 상하좌우
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 정상 시력
        visit = new boolean[N][N];
        int cnt1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    cnt1++;
                }
            }
        }

        // 적록색약 처리: G -> R 변환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') arr[i][j] = 'R';
            }
        }

        // 적록색약 카운트
        visit = new boolean[N][N];
        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true; // 시작점 방문 처리

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visit[nx][ny] && arr[nx][ny] == arr[cx][cy]) {
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
