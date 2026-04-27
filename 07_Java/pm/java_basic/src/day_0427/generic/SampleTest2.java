package day_0427.generic;

interface ISample<T> {
    public void addElement(T t, int index);
    public T getElement(int index);
}

class Sample<T> implements ISample<T> {
    private T[] array;

    public Sample() {
        array = (T[]) new Object[10];
    }

    @Override
    public void addElement(T element, int index) {
        array[index] = element;
    }

    @Override
    public T getElement(int index) {
        return array[index];
    }
}

public class SampleTest2 {
    public static void main(String[] args) {
        Sample<String> sample = new Sample<>();
        sample.addElement("This is string", 5);
        System.out.println(sample.getElement(5));
    }
}
