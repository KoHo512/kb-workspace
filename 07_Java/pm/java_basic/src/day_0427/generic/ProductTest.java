package day_0427.generic;

import practice_0423.Inheritance.prob2.Tv;

class Product<K, M> {    // 타입 파라미터 K, M 선언
    // 필드 - 타입 파라미터를 필드 타입으로 선언
    private K kind;
    private M model;

    public K getKind() {
        return this.kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Tv";
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product<Tv, String> p1 = new Product<>();
        p1.setKind(new Tv());
        p1.setModel("스마트TV");
        System.out.println("제품 종류 : " + p1.getKind());
        System.out.println("제품 모델 : " + p1.getModel());
    }
}
