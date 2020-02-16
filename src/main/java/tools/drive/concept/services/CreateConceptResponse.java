package tools.drive.concept.services;

import tools.drive.concept.domain.ConceptName;

import java.util.Objects;

public class CreateConceptResponse {
    private final ConceptName conceptName;

    public static CreateConceptResponse conceptCreated(ConceptName conceptName) {
        return new CreateConceptResponse(conceptName);
    }

    private CreateConceptResponse(ConceptName conceptName) {
        this.conceptName = conceptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateConceptResponse)) return false;
        CreateConceptResponse that = (CreateConceptResponse) o;
        return Objects.equals(conceptName, that.conceptName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conceptName);
    }

    @Override
    public String toString() {
        return "CreateConceptResponse{" +
                "conceptName=" + conceptName +
                '}';
    }
}
