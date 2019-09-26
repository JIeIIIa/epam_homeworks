package epam.lecture01.bitcounter;

public class ClassNameConverter {
    Class convert(String className) {
        switch (className.toLowerCase()) {
            case "byte": return byte.class;
            case "short": return short.class;
            case "int": return int.class;
            case "long": return long.class;
            default: throw new IllegalArgumentException("Class should be byte, short, int or long");
        }
    }
}
