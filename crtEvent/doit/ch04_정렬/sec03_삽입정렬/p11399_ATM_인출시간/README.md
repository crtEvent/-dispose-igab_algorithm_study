# 삽입정렬 (Insertion sort)
- 최선의 경우 전체 자료를 한번만 순회하면 되기때문에 $O(n)$
- 최악의 경우 $O(n^2)$ 의 시간복잡도를 가진다
  
- 이미 정렬된 데이터 범위 내에서 적절한 위치에 삽입하는 것
```text
0번 인덱스는 건너뛴다.
0~1번 인덱스 중 1번 인덱스 값이 들어가야할 위치를 찾아서 넣는다
0~2번 인덱스 중 2번 인덱스 값이 들어가야할 위치를 찾아서 넣는다
…
0~n번 인덱스 중 n번 인덱스 값이 들어가야할 위치를 찾아서 넣는다
```







# System.arraycopy()
```text
System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length);

Object src  : 복사해올 원본 배열
int srcPos  : 원본 배열에서 복사를 시작할 위치
Object dest : 붙여넣기 할 배열
int destPos : 붙여넣기 할 배열에서 붙여넣기 할 위치
int length  : 원본 배열에서 복사할 요소의 개수
```
```java
int[] arr = {1, 2, 3, 4, 5};
int[] temp = new int[5];

System.arraycopy(arr, 1, temp, 2, 3);
// arr 배열의 1번 위치부터 3개의 요소([2,3,4])를 temp 배열의 2번 위치 부터 붙여넣어 준다
System.out.println(Arrays.toString(temp));
// 결과: temp[0, 0, 2, 3, 4]
```

- 원하는 부분만 복사할 수 있다
- 불필요한 인스턴스 생성을 방지하여 메모리 자원 낭비를 예방
- 더 빠르게 실행된다
- 원본 배열의 특정 부분만을 선택해서 복사 가능
- JNI(Java Native Interface) ?????
    - 자바코드가 다른 코드로 작성된 라이브러리 or 운영체제 프로그램의 기능을 쓸 수 있게 하는 것
[효율적인 배열 복사 System.arrayCopy](https://tosuccess.tistory.com/169)<br>
[리스트와 배열 간 빠른 복사 방법](https://wikibook.co.kr/article/java-coding-with-pmd-usearraysaslist/)<br>
[System.arraycopy() 와Arrays.copyOf()의 차이](https://velog.io/@kai6666/Java-System.arraycopy-%EC%99%80Arrays.copyOf%EC%9D%98-%EC%B0%A8%EC%9D%B4-%EB%B0%B0%EC%97%B4-%EB%B3%B5%EC%82%AC)<br>
    
## 기타 배열 복사 메서드
- `array.clone()`
- `Arrays.copyOf(array, array.length)`

