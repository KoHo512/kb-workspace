package practice_0423.Inheritance.prob3;

public abstract class Account {
    private String accId;
    private String ownerName;
    private long balance;

    public Account() {}
    public Account(String accId, String ownerName, long balance) {
        this.accId = accId;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public abstract void calcRate();

    public void deposit(long money) {
        this.balance = this.balance + money;
    }

    public void withdraw(long money) {
        this.balance = this.balance - money;
    }

    public long getBalance() {
        return this.balance;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
