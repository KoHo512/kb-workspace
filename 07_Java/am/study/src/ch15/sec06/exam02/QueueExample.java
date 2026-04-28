package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Message> messageQueue = new LinkedList<>();

        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "김자바"));

        while (!messageQueue.isEmpty()) {
            Message message = messageQueue.poll();

            switch (message.command) {
                case "sendMail" -> System.out.println(message.to + "님에게 메일을 보냅니다.");
                case "sendSMS" -> System.out.println(message.to + "님에게 SMS을 보냅니다.");
                case "sendKakaotalk" -> System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
            }
            // 단일 책임 원칙 위배
            // 개방-폐쇄 원칙 위배

            // => 어떻게 개선할 수 있을지 고민해보는 게 중요

            // Command 패턴 - Map<String, 작업>
            // 멀티 스레드

            // => designPattern.command 패키지
        }
    }
}
