package mape.pattern.p08.chainofresponsibility;

public class Account {
    private final String number;
    private int money;

    public Account(String number, int money) {
        this.number = number;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Account#" + number +
                " {money=" + money +
                '}';
    }
}
