package mape.pattern.p02.abstractfactory.subtitle;

public abstract class Subtitle {
    private final String text;

    public Subtitle(String text) {
        this.text = text;
    }

    public void play() {
        System.out.println("text = " + text);
    }
}
