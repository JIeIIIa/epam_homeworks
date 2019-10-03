package mape.lab02.text;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Text {
    private final List<TextItem> items;

    private final String text;

    public Text(List<TextItem> items) {
        this.items = copy(items);
        this.text = makeText(this.items);
    }
    public List<TextItem> getElements() {
        return copy(items);
    }

    private String makeText(List<TextItem> textItems) {
        return textItems
            .stream()
            .map(TextItem::getText)
            .collect(Collectors.joining());
    }

    private List<TextItem> copy(List<TextItem> textItems) {
        return textItems.stream()
            .map(this::createCopy)
            .collect(Collectors.toList());
    }

    private TextItem createCopy(TextItem item) {
        if (TextItem.TYPE.SENTENCE.equals(item.getType())) {
            return new Sentence(((Sentence) item).getElements());
        } else if (TextItem.TYPE.SENTENCE_DELIMITER.equals(item.getType())) {
            return new SentenceDelimiter(item.getText());
        } else {
            throw new IllegalArgumentException("Wrong type: " + item.getType());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text that = (Text) o;
        return Objects.equals(text, that.text) &&
            Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, items);
    }

    @Override
    public String toString() {
        return text;
    }
}
