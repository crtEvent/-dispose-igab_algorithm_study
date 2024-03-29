# 퀵 정렬
```text
입력된 자료 리스트에서 하나의 원소를 고른다. 이 원소를 피벗이라고 부른다.
피벗을 기준으로 리스트를 둘로 분할한다.
피벗을 기준으로 피벗보다 작은 원소들은 모두 피벗의 왼쪽으로 옮긴다
피벗을 기준으로 피벗보다 큰 원소들은 모두 피벗의 오른쪽으로 옮긴다
```

- 기준값(pivot)을 선정해 기준값보다 작은 데이터와 큰 데이터로 분류하는 것을 반복해서 정렬
    - [1] 분할: 기준값을 기준으로 2개의 부분집합으로 분할
    - [2] 정복: 기준값 보다 작은 원소들은 왼쪽 부분집합으로, 기준값 보다 큰 우너소들은 오른쪽 부분집합으로
    - [3] 부분 집합의 크기가 1 이하가 될때 까지 반복
- 기준값을 어떻게 선정하는지가 시간 복잡도에 영향을 미친다
- 평균 시간 복잡도는 $n\log{n}$
  - 전체 원소를 정렬하지 않기 때문이다
- 최악의 경우(예를 들어 1:9)(1:n-1)로 나눠지는 경우 시간 복잡도는 $O(n^2)$
  - 이미 상당수가 정렬된 경우 불균형 분할에 의해 시간이 많이 걸리는 것
  
[퀵 정렬(Quick Sort)
#Goal](https://gyoogle.dev/blog/algorithm/Quick%20Sort.html)<br>
