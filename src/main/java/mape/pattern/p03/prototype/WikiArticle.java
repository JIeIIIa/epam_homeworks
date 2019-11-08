package mape.pattern.p03.prototype;

public class WikiArticle extends Article {
    public static WikiArticle EMPTY_WIKI_ARTICLE = new WikiArticle();

    private String section;

    public WikiArticle(){}


    public WikiArticle(WikiArticle wikiArticle) {
        super(wikiArticle);
        this.section = wikiArticle.section;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public Article copy() {
        return new WikiArticle(this);
    }

    @Override
    public String toString() {
        return "WikiArticle{" +
                "section='" + section + '\'' +
                ", " + super.toString() +
                '}';
    }
}
