package mape.pattern.p04.factorymethod;

public class Plus implements Shape {
    @Override
    public void print() {
        System.out.println(" * ");
        System.out.println("***");
        System.out.println(" *");
    }
}
