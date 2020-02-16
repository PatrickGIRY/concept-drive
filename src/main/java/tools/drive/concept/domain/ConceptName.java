package tools.drive.concept.domain;

import java.util.Objects;

public class ConceptName {
    private final String value;

    public static ConceptName valueOf(String value) {
        return new ConceptName(value);
    }

    private ConceptName(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConceptName)) return false;
        ConceptName that = (ConceptName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ConceptName{" +
                "value='" + value + '\'' +
                '}';
    }
}
