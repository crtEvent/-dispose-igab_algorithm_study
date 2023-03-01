package doit.ch03_스택_큐.p2164_카드_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_1 {

    // https://www.acmicpc.net/problem/2164

    // 현재 deck
    // idx :       0 1 2 3 4 5
    // value : (위) 1 2 3 4 5 6 (아래)

    // 2 3 4 5 6
    // 3 4 5 6 2
    // 4 5 6 2
    // 5 6 2 4
    // 6 2 4
    // 2 4 6
    // 4 6
    // 6 4
    // 4

    // 1 2 3 4
    // 2 3 4
    // 3 4 2
    // 4 2
    // 2 4
    // 4

    // 1 2 3
    // 2 3
    // 3 2
    // 2

    // 1 2 3 4 5
    // 2 3 4 5
    // 3 4 5 2
    // 4 5 2
    // 5 2 4
    // 2 4
    // 4 2
    // 2

    // 1 2
    // 2

    // N + N/2 이게 잘못임
    // 2(2), 3(4), 4(6), 5(8), 6(9)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> deck = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deck.add(i);
        }

        int index = 0;
        while(deck.size() > 1) {
            if(index++ % 2 == 0) {
                deck.remove(0);
            } else {
                deck.add(deck.get(0));
                deck.remove(0);
            }
        } // end - for()

        System.out.println(deck.get(0));

    }
}
