package day_0428.collection.p06;

import java.util.Stack;

public class MainTodo {
    public static void main(String[] args) {
        // TODO 1: Stack<String> 생성
        Stack<String> stack = new Stack<>();

        // TODO 2: "첫째", "둘째", "셋째" push
        stack.push("첫째");
        stack.push("둘째");
        stack.push("셋째");

        System.out.println(stack.size());

        // TODO 3: pop 하며 출력
//        for (String s : stack) {
//            System.out.println(s);
//            System.out.println(stack.size());
//        }

//        try {
//            String data = stack.pop();
//            System.out.println(data + ", " + stack.size());
//            data = stack.pop();
//            System.out.println(data + ", " + stack.size());
//            data = stack.pop();
//            System.out.println(data + ", " + stack.size());
//            data = stack.pop();
//            System.out.println(data + ", " + stack.size());
//        } catch (Exception e) {
//            System.out.println("더 이상 처리할 데이터가 없습니다.");
//        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
