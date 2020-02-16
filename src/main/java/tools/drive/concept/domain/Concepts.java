package tools.drive.concept.domain;

public interface Concepts {
    void append(Concept concept);
    boolean existsWithTheSameName(ConceptName conceptName);
}
