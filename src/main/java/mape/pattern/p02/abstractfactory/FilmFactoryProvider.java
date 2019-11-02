package mape.pattern.p02.abstractfactory;

public class FilmFactoryProvider {
    public enum Language {
        EN,
        UK
    }

    private FilmFactoryProvider() {
    }


    public static FilmFactory getFilmFactory(Language language) {
        if (Language.EN.equals(language)) {
            return new EnglishFilmFactory();
        } else if (Language.UK.equals(language)) {
            return new UkrainianFilmFactory();
        } else {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }
}
