// https://school.programmers.co.kr/learn/courses/30/lessons/12973?language=java

// 강의 코드
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (stk.isEmpty())
                stk.push(c);
            else 
                if (stk.peek() == c)
                    stk.pop();
                else
                    stk.push(c);
        }
        
        return stk.isEmpty() ? 1 : 0;
    }
}