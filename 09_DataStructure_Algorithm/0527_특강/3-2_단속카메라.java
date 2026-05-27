// https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=java

// 강의 코드
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int end = -30001;

        for (int[] route : routes) {
            int s = route[0];
            int e = route[1];
            
            if (end < s) {
                end = e;
                answer++;
            }
        }
        
        return answer;
    }
}