## 시행착오

```java
class Main {
    public static void main(String[] args) {
        while (!".".equals(s = br.readLine())) {
            int p = 0;
            while (p < s.length()) {
                char charP = s.charAt(p);
                switch (charP) {
                    case '(':
                    case '[':
                        stack.push(charP);
                        break;
                    case ')':
                        if (!stack.isEmpty() && ('(' == stack.peek())) {
                            stack.pop();
                        } else {
                            bw.write("no\n");
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && ('[' == stack.peek())) {
                            stack.pop();
                        } else {
                            bw.write("no\n");
                        }
                        break;
                    default:
                }
                p++;
            }
            if (stack.isEmpty()) {
                bw.write("yes\n");
            }
            stack.clear();
        }
    }
}
 ```
위 코드에서 no를 출력 후에도 반복문을 도는 버그가 있어서 no를 출력 후 아예 while문 자체를 나와야 했다.   
하지만 루프 두 개를 한 번에 나오는 방법이 없어서 함수로 분리해서 no 출력 후 리턴을 해줌으로써 한 번에 두 루프를 나오도록 고쳤다.   
원래 if-else로 구현해서 더러웠지만 crtEvent와 new_pow의 코드를 참고해서 switch문으로 개선했다.
