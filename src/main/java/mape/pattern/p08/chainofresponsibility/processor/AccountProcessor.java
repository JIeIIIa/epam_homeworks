package mape.pattern.p08.chainofresponsibility.processor;

import mape.pattern.p08.chainofresponsibility.Account;

public abstract class AccountProcessor {
    private final AccountProcessor nextProcessor;

    protected AccountProcessor(AccountProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }


    public abstract Account proceed(Account account);

    protected Account doNext(Account account) {
        if (nextProcessor == null) {
            return account;
        }
        return nextProcessor.proceed(account);
    }
}
