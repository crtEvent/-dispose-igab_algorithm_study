package doit.ch03_스택_큐.p4949_균형잡힌_세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_3 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String sentence = br.readLine();

            if(sentence.equals(".")){
                System.out.println(sb.toString());
                System.exit(0);
            }

            logic(sentence, sb);
        }

    }

    public static void logic(String sentence, StringBuilder sb) {
        char[] arr = sentence.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case '(':
                case '[':
                    stack.addFirst(arr[i]);
                    break;
                case ')':
                case ']':
                    char c = (arr[i] == ')')? '(' : '[';
                    if(stack.isEmpty()){
                        sb.append("no"+System.lineSeparator());
                        return;
                    } else if(stack.peekFirst() == c) {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(arr[i]);
                    }
                    break;
            } // end - switch

        } // end - for

        if(stack.isEmpty()) {
            sb.append("yes"+System.lineSeparator());
        } else {
            sb.append("no"+System.lineSeparator());
        }
    }
}

