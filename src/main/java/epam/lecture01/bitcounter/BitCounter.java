package epam.lecture01.bitcounter;

// 3. Используя побитовые операции подсчитать
//    количество занимаемых бит для byte,short, int, long.

public class BitCounter {
    public static void main(String[] args) {
        BitCounterService bitCounterService = new BitCounterService();
        System.out.println("byte  has " + bitCounterService.proceed(byte.class) + " bits");
        System.out.println("short has " + bitCounterService.proceed(short.class) + " bits");
        System.out.println("int   has " + bitCounterService.proceed(int.class) + " bits");
        System.out.println("long  has " + bitCounterService.proceed(long.class) + " bits");
    }
}
