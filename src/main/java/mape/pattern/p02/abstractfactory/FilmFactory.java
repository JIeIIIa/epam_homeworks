package mape.pattern.p02.abstractfactory;

import mape.pattern.p02.abstractfactory.sound.Sound;
import mape.pattern.p02.abstractfactory.subtitle.Subtitle;

public interface FilmFactory {
    Subtitle makeSubtitle(String filmName);
    Sound makeSound(String filmName);
}
