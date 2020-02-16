package tools.drive.concept.services;

import tools.drive.concept.domain.Concept;
import tools.drive.concept.domain.ConceptName;
import tools.drive.concept.domain.Concepts;

public class CreateConceptService {
    private final Concepts concepts;

    public CreateConceptService(Concepts concepts) {
        this.concepts = concepts;
    }

    public void createConcept(ConceptName conceptName) {
        concepts.append(Concept.named(conceptName));
    }
}
