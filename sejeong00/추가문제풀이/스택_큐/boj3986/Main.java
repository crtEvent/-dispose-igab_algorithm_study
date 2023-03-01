package 추가문제풀이.스택_큐.boj3986;

import java.io.*;
import java.util.Stack;

public class Main {
    //백준 3986
    //키워드 : 단어 길이의 합 1,000,000 => 자료구조 써야됨
    // 딱히 키워드는 없고 가장 가까이에 있는
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        int goodNumCnt = 0;

        for(int i = 0; i < cnt; i++){
            String s = br.readLine();

            int p = 0;
            while(p < s.length()){
                char charP = s.charAt(p);
                if(!stack.isEmpty() && charP == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(charP);
                }

//                if(stack.isEmpty()){
//                    stack.push(charP);
//                }else if(charP != stack.peek()){
//                    if(stack.size() > 1){
//                        break;
//                    }else{
//                        stack.push(charP);
//                    }
//                }else{
//                    stack.pop();
//                }
                p++;
            }
            if(stack.isEmpty()){
                goodNumCnt++;
            }
            stack.clear();
        }
        bw.write(goodNumCnt + "");
        bw.flush();
    }
}
