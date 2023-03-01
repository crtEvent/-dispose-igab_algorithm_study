# 문제 011. 스택으로 오름차순 수열 만들기 (81p)
- [백준 1874번 - 스택 수열](https://www.acmicpc.net/problem/1874)

## Point 1. 오름차순 수열?
- 수열(sequence)이란?
  - 수의 순서있는 나열
  - 어떤 규칙에 따라서 숫자들을 늘어놓은 것
  - 일정한 규칙에 따라 한 줄로 배열된 수의 열
- 처음에 오름차순 수열이라는 말때문에 문제를 잘못 이해함
  - Stack 을 활용해서 입력값을 오름차순으로 정렬하라는 뜻으로 이해함
  - 백준 사이트에는 오름차순이라는 말이 없고 문제에 대한 설명이 더 자세하다

## Point 2. Stack이 아닌 ArrayDeque를 쓰는 이유?
### 속도 측면 - pop(), peek()에 synchronized가 붙어 있다
```java
class Stack<E> extends Vector<E> {
    // ... 생략
    public synchronized E pop() {
        // ... 생략
    }

    public synchronized E peek() {
        // ... 생략
    }
    // ... 생략
}
```
- Thread-safe
- 멀티스레드 환경이 아닐 때 사용하면 lock을 거는 작업 때문에 많은 오버헤드가 발생
- ArrayDeque 공식문서에 보면 스택구조로 사용하면 Stack 클래스보다 빠르고, 큐 구조로 사용하면 Queue 클래스보다 빠르다고 한다

### Stack은 index로 접근 가능 / Deque는 불가능
- Deque는 중간에서 삽입, 삭제할수 없다

[[Java] Deque (덱/데크) 사용법 및 예제](https://hbase.tistory.com/128)<br>
[Java 자료구조 파헤치기 #8 Java 자료구조 파헤치기 ArrayDeque](https://sup2is.github.io/2019/09/23/array-deque.html)<br>
[[Java] Stack 클래스는 무엇이고 문제점은 무엇일까?](https://devlog-wjdrbs96.tistory.com/244)<br>
[자바에서 Vector와 Stack 컬렉션이 쓰이지 않는 이유?](https://aahc.tistory.com/8)<br>

### 실제로 테스트 해보니
```text
[ArrayDeque]
push 실행 시간: 4394
pop 실행 시간: 577

addLast 실행 시간: 4172
removeLast 실행 시간: 632

addFirst 실행 시간: 3616
removeFirst 실행 시간: 539

[Stack]
push 실행 시간: 4882
pop 실행 시간: 666

push 실행 시간: 3772
pop 실행 시간: 939

push 실행 시간: 3273
pop 실행 시간: 696

push 실행 시간: 3516
pop 실행 시간: 723
```
- pop은 확실히 ArrayDeque가 조금 더 빠르다 
- push는 Stack이 더 빠르게 나온느 경우도 있음
- 왜?

## Point3. StringBuilder / StringBuffer 무슨 차이?
- StringBuffer는 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전하다는 점(thread-safe)
- StringBuilder는 동기화를 지원하지 않기때문에 단일쓰레드에서의 성능은 StringBuffer 보다 뛰어납니다.
- [StringBuffer  vs  StringBuilder](https://ifuwanna.tistory.com/221)

## No 가 나오는 케이스를 이해 못 하겠다
5 : 1 2 5 3 4

| push/pop    | 1~5 순서대로 | 결과 수열         |
|--------|----------|---------------|
| push 1 | {1}      | {}            |
| pop 1  | {}       | {1}           |
| push 2 | {2}      | {}            |
| pop 2  | {}       | {1 2}         |
| push 3 | {3}      | {1 2}         |
| push 4 | {3 4}    | {1 2}         | 
| push 5 | {3 4 5}  | {1 2}         |
| pop 5  | {3 4}    | {1 2 5}       |
| pop 4? | {3}      | {1 2 5 4(NO)} |
- [블로그 참조 - 백준 1874번 : 스택 수열(Java)](https://today-retrospect.tistory.com/89)