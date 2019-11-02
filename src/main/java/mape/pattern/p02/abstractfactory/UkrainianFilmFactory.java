package mape.pattern.p02.abstractfactory;

import mape.pattern.p02.abstractfactory.sound.Sound;
import mape.pattern.p02.abstractfactory.sound.UkrainianSound;
import mape.pattern.p02.abstractfactory.subtitle.Subtitle;
import mape.pattern.p02.abstractfactory.subtitle.UkrainianSubtitle;

public class UkrainianFilmFactory implements FilmFactory {

    @Override
    public Subtitle makeSubtitle(String filmName) {
        return new UkrainianSubtitle(filmName);
    }

    @Override
    public Sound makeSound(String filmName) {
        return new UkrainianSound(filmName);
    }
}
