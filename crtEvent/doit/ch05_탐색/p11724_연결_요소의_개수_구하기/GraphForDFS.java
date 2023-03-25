package doit.ch05_탐색.p11724_연결_요소의_개수_구하기;

import java.util.LinkedList;
import java.util.Stack;

public class GraphForDFS {
    // DFS 구현해보기 1
    // https://www.youtube.com/watch?v=_hxFgg7TLZQ

    class Node {
        int data;
        LinkedList<Node> adjaccent; // 인접한 노드
        boolean marked; // flag 변수

        Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjaccent = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    GraphForDFS(int size) {
        nodes = new Node[size];
        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if(!n1.adjaccent.contains(n2)) {
            n1.adjaccent.add(n2);
        }
        if(!n2.adjaccent.contains(n1)) {
            n2.adjaccent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjaccent) {
                if(!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            // 출력
            System.out.print(r.data + " ");
        }
    }

    public static void main(String[] args) {
        /*
       그래프
          0
         /
        1 -- 3    7
        |  / | \ /
        | /  |  5
        2 -- 4   \
                  6 - 8
         */

        GraphForDFS graph = new GraphForDFS(9);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        graph.dfs();

    }
}
