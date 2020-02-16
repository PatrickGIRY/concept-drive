package tools.drive.concept.domain;

import java.util.Objects;

public class Concept {
    private final ConceptName name;

    public static Concept named(ConceptName name) {
        return new Concept(name);
    }

    private Concept(ConceptName name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Concept)) return false;
        Concept concept = (Concept) o;
        return Objects.equals(name, concept.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Concept{" +
                "name=" + name +
                '}';
    }
}
