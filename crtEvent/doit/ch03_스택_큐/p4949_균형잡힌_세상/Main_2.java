package doit.ch03_스택_큐.p4949_균형잡힌_세상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_2 {

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
        String[] arr = sentence.replaceAll("[^(\\(\\)\\[\\])]", "").split("");
        Deque<String> stack = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++) {
            switch(arr[i]) {
                case "(":
                case "[":
                    stack.addFirst(arr[i]);
                    break;
                case ")":
                    if(stack.isEmpty()){
                        sb.append("no"+System.lineSeparator());
                        return;
                    } else if(stack.peekFirst().equals("(")) {
                        stack.removeFirst();
                    } else {
                        stack.addFirst(arr[i]);
                    }
                    break;
                case "]":
                    if(stack.isEmpty()){
                        sb.append("no"+System.lineSeparator());
                        return;
                    } else if(stack.peekFirst().equals("[")) {
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
