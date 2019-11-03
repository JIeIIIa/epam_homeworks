package mape.pattern.p02.abstractfactory.sound;

public abstract class Sound {
    private final String sound;

    public Sound(String sound) {
        this.sound = sound;
    }

    public void play() {
        System.out.println("sound = " + sound);
    }
}
