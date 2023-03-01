package 추가문제풀이.스택_큐.boj10799_쇠막대기;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        int pipeCnt = 0;
        boolean isPrevieousOpen = false;

        for(int i = 0; i < s.length(); i++){
            char charI = s.charAt(i);
            if(charI == '('){
                isPrevieousOpen = true;
                stack.push(charI);
            }else if(charI == ')'){
                if(isPrevieousOpen) {
                    pipeCnt += stack.size() - 1;
                }else{
                    pipeCnt++;
                }
                isPrevieousOpen = false;
                stack.pop();
            }
        }

        bw.write(pipeCnt + "");
        bw.flush();

    }
}

//(((( ) (( ) ( ))) (( )) ( ))) (( ) ( ))
//(((( ) (( ) ( ))) (( )) ( ))) (( ) ( ))
