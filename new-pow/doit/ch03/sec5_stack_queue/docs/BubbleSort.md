# 버블 정렬
## Process
서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬하는 알고리즘 이다.

![](https://github.com/GimunLee/tech-refrigerator/raw/master/Algorithm/resources/bubble-sort-001.gif)

## 특징
- 장점
    - 구현이 매우 간단하다.
    - 정렬하고자 하는 배열 안에서 교환하는 방식이므로, 다른 메모리 공간을 필요로 하지 않다. => 제자리 정렬(in-place sorting)
- 단점
    - 하나의 요소가 가장 왼쪽에서 가장 오른쪽으로 이동하기 위해서는 배열에서 모든 다른 요소들과 교환되어야 한다.
    - 정렬 돼있지 않은 원소가 정렬 됐을때의 자리로 가기 위해서, 교환 연산(swap)이 많이 일어나게 된다.
    - 일반적으로 자료의 교환 작업(SWAP)이 자료의 이동 작업(MOVE)보다 더 복잡하기 때문에 버블 정렬은 단순성에도 불구하고 거의 쓰이지 않는다.

## 시간 복잡도
- 시간 복잡도
    - `(n-1) + (n-2) + (n-3) + .... + 2 + 1 => n(n-1)/2`이므로, `O(n^2)` 이다.
    - Bubble Sort는 무조건 2개의 원소를 비교하기 때문에 최선, 평균, 최악의 경우 모두 시간복잡도가 O(n^2) 으로 동일하다.
- 공간 복잡도
    - 주어진 배열 안에서 교환(swap)을 통해, 정렬이 수행되므로 O(n) 이다.

![](https://gmlwjd9405.github.io/images/algorithm-bubble-sort/sort-time-complexity.png)
