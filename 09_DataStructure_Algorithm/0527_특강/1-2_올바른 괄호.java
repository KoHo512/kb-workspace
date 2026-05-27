// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

// 강의 코드
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') 
                stk.push('(');
            else {
                if (stk.isEmpty())
                    return false;
                else {
                    stk.pop();
                }
            }
        }
        
        if (stk.isEmpty())
            return true;
        
        return false;
    }
}