package day_0417;

class AddArray {
    public int addArray(int[] arrayRefer) {
        int total = 0;

        for (int i = 0; i < arrayRefer.length; i++) {
            total += arrayRefer[i];
        }

        return total;
    }

}

public class CallByReference {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        int result1 = addArray(a);
        System.out.println("총합 : " + result1);

        AddArray aa = new AddArray();
        int result2 = aa.addArray(a);
        System.out.println("총합 : " + result2);
    }

    public static int addArray(int[] arrayRefer) {
        int total = 0;

        for (int i = 0; i < arrayRefer.length; i++) {
            total += arrayRefer[i];
        }

        return total;
    }
}
