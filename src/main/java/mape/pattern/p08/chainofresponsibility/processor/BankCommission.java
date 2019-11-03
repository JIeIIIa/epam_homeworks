package mape.pattern.p08.chainofresponsibility.processor;

import mape.pattern.p08.chainofresponsibility.Account;

public class BankCommission extends AccountProcessor {

    public BankCommission() {
        super(null);
    }

    public BankCommission(AccountProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public Account proceed(Account account) {
        int money = account.getMoney();
        int commission = (int) (money * 0.5);
        System.out.println("Account " + account.getNumber() + " : bank commission = " + commission);
        account.setMoney(money - commission);

        return doNext(account);
    }
}
