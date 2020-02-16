package tools.drive.concept.services;

import tools.drive.concept.domain.Concept;
import tools.drive.concept.domain.ConceptName;
import tools.drive.concept.domain.Concepts;

public class CreateConceptService {
    private final Concepts concepts;

    public CreateConceptService(Concepts concepts) {
        this.concepts = concepts;
    }

    public CreateConceptResponse createConcept(ConceptName conceptName) {
        if (!concepts.existsWithTheSameName(conceptName)) {
            concepts.append(Concept.named(conceptName));
            return CreateConceptResponse.conceptCreated(conceptName);
        } else {
            return CreateConceptResponse.conceptAlreadyExistsWithName(conceptName);
        }
    }
}
