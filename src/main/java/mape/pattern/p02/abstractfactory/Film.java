package mape.pattern.p02.abstractfactory;

import mape.pattern.p02.abstractfactory.sound.Sound;
import mape.pattern.p02.abstractfactory.subtitle.Subtitle;

public class Film {
    private final String title;
    private Subtitle subtitle;
    private Sound sound;

    public Film(String title, Subtitle subtitle, Sound sound) {
        this.title = title;
        this.subtitle = subtitle;
        this.sound = sound;
    }

    public void play() {
        System.out.println("Playing film '" + title+ "':");
        sound.play();
        subtitle.play();
    }
}
