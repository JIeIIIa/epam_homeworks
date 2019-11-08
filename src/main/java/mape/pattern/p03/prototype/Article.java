package mape.pattern.p03.prototype;

import java.util.Objects;

public class Article implements Copyable {
    private String content;

    public Article() {
    }

    public Article(Article article) {
        this.content = article.content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Article copy() {
        return new Article(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Article{" +
                "content='" + content + '\'' +
                '}';
    }
}
