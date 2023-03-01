package doit.ch03_스택_큐.p2164_카드_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> deck = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            deck.add(i);
        }

        while(deck.size() > 1) {
            deck.remove(0);
            deck.add(deck.get(0));
            deck.remove(0);
        } // end - for()

        System.out.println(deck.get(0));

    }
}
