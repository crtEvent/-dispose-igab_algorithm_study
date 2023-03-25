package doit.ch05_탐색.p11724_연결_요소의_개수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Book {
    /*
    [예제 분석 1]
    노드 개수: 6, 에지 개수: 5
    1 - 2     3 - 4 - 6
      \ |
        5
    => 연결 요소의 수 : 2

    [예제 분석 2]
    노드 개수: 6, 에지 개수: 8
    1 - 2 - 3
      \ | \ |
        5 - 4 - 6
    => 연결 요소의 수 : 1

     */

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 에지 개수
        
        A = new ArrayList[n + 1]; // 왜 n+1인가? A의 index를 node 값과 일치시키기 위해. A의 0번은 사용하지 않는다.
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) { // 인접 리스트 초기화
            A[i] = new ArrayList<Integer>(); // List 안에 List 가 있는 구조
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // A의 인덱스가 각 노드를 의미
            //  A[i] 안에 add한 값이 i 노드와 연결된 노드를 의미
            A[s].add(e); // 양 방향 간선이므로 양쪽으로 간선을 더 해준다
            A[e].add(s); // ↑ s와 e는 연결되어 있으니까 서로 추가해준다는 뜻
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) { // 방문하지 않은 노드가 없을 때까지 반복
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int v) {
        if (visited[v]) { // 방문한 적 있으면 끝
            return;
        }
        visited[v] = true; // 방문한 적 없으면 방문했다고 true 표시
        for (int i : A[v]) {
            if (!visited[i]) { // 연결된 노드 중 방문하지 않았던 노드만 다시 탐색함
                DFS(i);
            }
        }
    }
}
