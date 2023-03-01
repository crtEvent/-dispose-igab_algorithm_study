
## StringBuilder로 출력하는게 훨씬 빠르구나!

## Comparator 어떻게 쓰는 건가?
```java
(o1, o2) ->
        {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            
            if(abs1 != abs2){
                return abs1 - abs2;
            }else{
                return o1-o2;
        }
```
```java
(o1, o2) ->
        {
            int answer = Math.abs(a) - Math.abs(b);
            if (answer == 0) {
                answer = a - b;
            }
            return answer;
        }
```


## 