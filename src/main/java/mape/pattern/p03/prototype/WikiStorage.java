package mape.pattern.p03.prototype;

import java.util.HashMap;
import java.util.Map;

public class WikiStorage {
    private Map<String, Article> articles = new HashMap<>();
    private Map<String, Article> oldArticles = new HashMap<>();

    public void addArticle(String key, Article article) {
        Article current = articles.getOrDefault(key, WikiArticle.EMPTY_WIKI_ARTICLE);
        oldArticles.put(key, current);
        articles.put(key, article);
    }

    public void restore(String key) {
        Article oldArticle = oldArticles.remove(key);
        if (oldArticle == null) {
            System.out.println("Previous version is not available.");
            return;
        }
        articles.put(key, oldArticle);
    }

    public WikiArticle give(String key) {
        Article article = articles.get(key);
        if (article == null) {
            System.out.println("Article with key = " + key + " not found.");
            return null;
        }

        return (WikiArticle) article.copy();
    }

    public void printAll() {
        System.out.println("Current versions:");
        articles.forEach((key, value) -> System.out.println(key + ":  " + value));
        System.out.println("Old versions:");
        oldArticles.forEach((key, value) -> System.out.println(key + ":  " + value));
    }
}
