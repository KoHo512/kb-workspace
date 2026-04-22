package practice_0422.payment;

public class CashPayment extends Payment {
    private String cashReceiptNumber;

    public CashPayment(String shopName, String productName, long productPrice, String cashReceiptNumber) {
        super(shopName, productName, productPrice);
        this.cashReceiptNumber = cashReceiptNumber;
    }

    @Override
    public void pay() throws PayException {
        if (productPrice <= 0) {
            throw new PayException("가격이 잘못되었습니다.");
        } else {
            System.out.println("현금이 정상적으로 지불되었습니다.");
        }
    }

    @Override
    public String toString() {
        return "[ 현금 결제 정보 ]\n" +
                "상점명 : " + shopName + '\n' +
                "상품명 : " + productName + '\n' +
                "상품가격 : " + productPrice + '\n' +
                "현금영수증번호 : " + cashReceiptNumber;
    }
}
