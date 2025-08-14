import java.io.*;
import java.util.*;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] adj;
    static int[] color; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        K = Integer.parseInt(br.readLine().trim());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                adj[b].add(a);
            }

            color = new int[V + 1];
            boolean ok = isBipartiteBFS();
            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out.toString());
    }

    static boolean isBipartiteBFS() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= V; i++) {
            if (color[i] != 0) continue;   

            color[i] = 1;                  
            q.add(i);

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int next : adj[cur]) {
                    if (color[next] == 0) {             
                        color[next] = 3 - color[cur];    
                        q.add(next);
                    } else if (color[next] == color[cur]) {
                        return false;                    
                    }
                }
            }
        }
        return true; 
    }
}