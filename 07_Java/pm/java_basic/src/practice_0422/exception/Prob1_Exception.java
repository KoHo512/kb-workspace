package practice_0422.exception;

/**
 * 사용자로부터 문자열을 입력받아서 그 문자열을 숫자로 변환하여 출력하는 프로그램입니다.
 * 1> convert라는 메서드를 정의합니다.
 * A. 문자열을 전달받아서, 그 문자열을 숫자로 변환하여 리턴합니다.
 * B. 전달된 문자가 null이거나 문자열의 길이가 0이면
 * IllegalArgumentException 을 발생시킨 후 메소드를 호출한 쪽으로 예외를 던집니다.
 * 2> main메서드에서 convert를 호출하고 결과를 출력합니다.
 * 3> 예외가 발생되면, “예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.”라고 출력합니다
 **/

import java.util.Scanner;
//BufferedReader(new InputStreamReader(System.in)) 사용하셔도 됩니다.

public class Prob1_Exception {
    // 예외 발생 시 출력할 메시지
    private static final String INVALID_NUMBER_ERROR_MESSAGE = "예외가 발생되었습니다. 숫자로 변환 가능한 문자열을 입력 바랍니다.";
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.";

    //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자로 변환할 문자열 입력 : ");
        String str = scan.nextLine();

        //여기를 작성하십시오.
        try {
            int result = convert(str);
            System.out.println("변환된 숫자는 " + result + "입니다.");
        } catch (NumberFormatException e) {
            System.out.println(INVALID_NUMBER_ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            System.out.println(EMPTY_INPUT_ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e.getMessage());
        } finally {
            scan.close();
        }
    }

    //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
    private static int convert(String str) throws IllegalArgumentException {
        //여기를 작성하십시오.
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(str);
    }

}