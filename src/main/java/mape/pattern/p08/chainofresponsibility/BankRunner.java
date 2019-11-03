package mape.pattern.p08.chainofresponsibility;

import mape.pattern.p08.chainofresponsibility.processor.AccountProcessor;
import mape.pattern.p08.chainofresponsibility.processor.BankCommission;
import mape.pattern.p08.chainofresponsibility.processor.LoggingProcessor;
import mape.pattern.p08.chainofresponsibility.processor.VerificationProcessor;

public class BankRunner {
    public static void main(String[] args) {
        final Account standard = new Account("st1111_2222_3333_4444", 30000);
        final AccountProcessor standardChain = buildStandardChain();
        Account result = standardChain.proceed(standard);
        System.out.println("Result: " + result);
        System.out.println();

        final Account nonSupported = new Account("qwerty", 777);
        result = standardChain.proceed(nonSupported);
        System.out.println("Result: " + result);
        System.out.println();

        final Account exemption = new Account("ex_0000_0007", 10000);
        final AccountProcessor exemptionChain = buildExemptionChain();
        result = exemptionChain.proceed(exemption);
        System.out.println("Result: " + result);
    }

    private static AccountProcessor buildStandardChain() {
        AccountProcessor accountProcessor = new BankCommission();
        accountProcessor = new VerificationProcessor(accountProcessor);
        accountProcessor = new LoggingProcessor(accountProcessor);

        return accountProcessor;
    }

    private static AccountProcessor buildExemptionChain() {
        AccountProcessor accountProcessor = new VerificationProcessor();
        accountProcessor = new LoggingProcessor(accountProcessor);

        return accountProcessor;
    }
}
