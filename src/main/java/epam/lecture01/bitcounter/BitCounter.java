package epam.lecture01.bitcounter;

// 3. Используя побитовые операции подсчитать
//    количество занимаемых бит для byte,short, int, long.

public class BitCounter {
    public static void main(String[] args) {
        ClassNameConverter classNameConverter = new ClassNameConverter();
        BitCounterService bitCounterService = new BitCounterService(classNameConverter);
        System.out.println("byte  has " + bitCounterService.proceed("byte") + " bits");
        System.out.println("short has " + bitCounterService.proceed("short") + " bits");
        System.out.println("int   has " + bitCounterService.proceed("int") + " bits");
        System.out.println("long  has " + bitCounterService.proceed("long") + " bits");
    }
}
