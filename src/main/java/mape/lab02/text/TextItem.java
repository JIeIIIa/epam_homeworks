package mape.lab02.text;

public interface TextItem {
    enum TYPE {
        UNKNOWN,
        SENTENCE,
        WORD,
        CHAR,
        SENTENCE_DELIMITER,
        WORD_DELIMITER
    }

    String getText();

    default TYPE getType() {
        return TYPE.UNKNOWN;
    }
}
