package mape.pattern.p08.chainofresponsibility.processor;

import mape.pattern.p08.chainofresponsibility.Account;

public class LoggingProcessor extends AccountProcessor {
    public LoggingProcessor() {
        super(null);
    }

    public LoggingProcessor(AccountProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public Account proceed(Account account) {
        System.out.println("Proceed account: " + account);

        return doNext(account);
    }
}
