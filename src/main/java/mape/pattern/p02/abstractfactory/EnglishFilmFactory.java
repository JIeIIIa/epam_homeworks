package mape.pattern.p02.abstractfactory;

import mape.pattern.p02.abstractfactory.sound.EnglishSound;
import mape.pattern.p02.abstractfactory.sound.Sound;
import mape.pattern.p02.abstractfactory.subtitle.EnglishSubtitle;
import mape.pattern.p02.abstractfactory.subtitle.Subtitle;

public class EnglishFilmFactory implements FilmFactory {

    @Override
    public Subtitle makeSubtitle(String filmName) {
        return new EnglishSubtitle(filmName);
    }

    @Override
    public Sound makeSound(String filmName) {
        return new EnglishSound(filmName);
    }
}
