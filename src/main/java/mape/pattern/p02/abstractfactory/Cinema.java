package mape.pattern.p02.abstractfactory;

import mape.pattern.p02.abstractfactory.FilmFactoryProvider.Language;
import mape.pattern.p02.abstractfactory.sound.Sound;
import mape.pattern.p02.abstractfactory.subtitle.Subtitle;

import static mape.pattern.p02.abstractfactory.FilmFactoryProvider.Language.UK;

public class Cinema {
    public static void main(String[] args) {
        Language language = UK;
        String filmTitle = "Terminator";

        Film film = getFilm(language, filmTitle);
        film.play();
    }

    private static Film getFilm(Language language, String filmTitle) {
        FilmFactory filmFactory = FilmFactoryProvider.getFilmFactory(language);
        final Subtitle subtitle = filmFactory.makeSubtitle(filmTitle);
        final Sound sound = filmFactory.makeSound(filmTitle);

        return new Film(filmTitle, subtitle, sound);
    }
}
