package mape.pattern.p03.prototype;

public class WikiRunner {

    public static final String KEY = "key";

    public static void main(String[] args) {
        WikiStorage storage = new WikiStorage();

        WikiArticle wikiArticle = new WikiArticle();
        wikiArticle.setSection("General");
        wikiArticle.setContent("Some text");

        storage.addArticle("key", wikiArticle);
        storage.printAll();
        System.out.println("-------------------");

        WikiArticle article = storage.give("key");
        article.setContent("New content");
        storage.addArticle(KEY, article);
        storage.printAll();

        System.out.println("-------------------");
        storage.restore(KEY);
        storage.printAll();
    }
}
