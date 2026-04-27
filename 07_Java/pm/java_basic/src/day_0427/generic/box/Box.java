package day_0427.generic.box;

// 어떤 물건이든 담을 수 있는 박스 클래스
public class Box<T> {
    public T content;

    // 박스에 담긴 내용물이 같은 물건인지 판단하는 기능
    public boolean compare(Box<T> other) {
        boolean result = content.equals(other.content);

        return result;
    }
}
