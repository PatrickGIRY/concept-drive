package tools.drive.concept.services;

import tools.drive.concept.domain.ConceptName;

import java.util.Objects;

public abstract class CreateConceptResponse {
    private final ConceptName conceptName;

    public static CreateConceptResponse conceptCreated(ConceptName conceptName) {
        return new ConceptCreated(conceptName);
    }

    public static CreateConceptResponse conceptAlreadyExistsWithName(ConceptName conceptName) {
        return new ConceptAlreadyExists(conceptName);
    }

    private CreateConceptResponse(ConceptName conceptName) {
        this.conceptName = conceptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() == getClass())) return false;
        var that = getClass().cast(o);
        return Objects.equals(conceptName, that.conceptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conceptName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "conceptName=" + conceptName +
                '}';
    }

    private static class ConceptCreated extends CreateConceptResponse {
        private ConceptCreated(ConceptName conceptName) {
            super(conceptName);
        }
    }

    private static class ConceptAlreadyExists extends CreateConceptResponse {
        private ConceptAlreadyExists(ConceptName conceptName) {
            super(conceptName);
        }
    }
}
