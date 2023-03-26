package doit.ch05_search.sec1_dfs;

import java.io.*;
import java.util.*;

// 틀림
public class BOJ11724_1_fail {

    public static void main(String[] args) throws Exception {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // node
        int m = Integer.parseInt(st.nextToken());   // edge

        boolean[][] graph = new boolean[n+1][n+1];
        boolean[] visit = new boolean[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = true;
        }

        int result = 0;

        // search
        for (int i=0; i<graph.length; i++) {
            if (visit[i]) {
                dfs(graph, visit, i);
                result ++;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(boolean[][] graph, boolean[] visit, int i) {
        if (visit[i]) return;
        visit[i] = true;

        for (int j=0; j<graph.length; j++) {
            if (graph[i][j] && !visit[j]) {
                dfs(graph,visit,j);
            }
        }
    }
}
