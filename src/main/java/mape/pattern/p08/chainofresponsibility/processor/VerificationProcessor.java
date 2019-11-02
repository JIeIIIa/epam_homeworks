package mape.pattern.p08.chainofresponsibility.processor;

import mape.pattern.p08.chainofresponsibility.Account;

public class VerificationProcessor extends AccountProcessor {
    public VerificationProcessor() {
        super(null);
    }

    public VerificationProcessor(AccountProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public Account proceed(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account is null");
        }

        final String number = account.getNumber();
        if(number == null || number.length() < 10 ) {
            System.out.println("Not supported account number: " + account);
            return account;
        }

        System.out.println("Verification success: " + account);
        return doNext(account);
    }
}
