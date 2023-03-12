- Arrays.sort()와 Collections.sort()에 대해서 자세히 알아본다.
  - primitive(기본형) 타입의 배열인 경우  DualPivotQuicksort를 사용
  - reference(참조) 타입의 배열인 경우 ComparableTimSort클래스의 sort() 메서드를 사용


- 결론
  결국 정렬을 수행하기 위해서 사용되는 메서드는 Arrays.sort()이다.
그러나 어떤 타입의 배열을 받느냐에 따라서 실행되는 정렬 알고리즘이 달라진다.
> > 참고자료 : https://javanitto.tistory.com/6
> https://codingnojam.tistory.com/38
