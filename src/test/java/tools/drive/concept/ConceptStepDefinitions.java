package tools.drive.concept;

import io.cucumber.java8.En;
import tools.drive.concept.domain.Concept;
import tools.drive.concept.domain.ConceptName;
import tools.drive.concept.domain.Concepts;
import tools.drive.concept.services.CreateConceptResponse;
import tools.drive.concept.services.CreateConceptService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConceptStepDefinitions implements En {

    private final CreateConceptService createConceptService;
    private CreateConceptResponse createConceptResponse;
    private ConceptName conceptName;
    private boolean conceptAlreadyExists;
    private Concept conceptAppended;

    public ConceptStepDefinitions() {

        this.createConceptService = new CreateConceptService(new Concepts() {

            @Override
            public void append(Concept concept) {
                conceptAppended = concept;
            }

            @Override
            public boolean existsWithTheSameName(ConceptName conceptName) {
                return conceptAlreadyExists;
            }
        });

        Given("^a concept named (\\w+)", (String conceptName) ->
                this.conceptName = ConceptName.valueOf(conceptName));

        Given("no concept exists with the same name", () ->
                this.conceptAlreadyExists = false);

        Given("^a concept with the same name already exists$", () ->
                this.conceptAlreadyExists = true);

        When("^the concept is created$", () ->
                this.createConceptResponse = this.createConceptService.createConcept(conceptName));

        Then("^a new concept named (\\w+) is appended to the concepts$", (String conceptName) ->
                assertThat(this.conceptAppended)
                        .isEqualTo(Concept.named(ConceptName.valueOf(conceptName))));

        Then("^no new concept should be appended$", () ->
                assertThat(this.conceptAppended).isNull());

        Then("^a concept named (\\w+) is created should be returned$", (String conceptName) ->
                assertThat(createConceptResponse)
                        .isEqualTo(CreateConceptResponse.conceptCreated(ConceptName.valueOf(conceptName))));

        Then("^a concept already exists with the name (\\w+) should be returned$", (String conceptName) ->
                assertThat(createConceptResponse)
                        .isEqualTo(CreateConceptResponse.conceptAlreadyExistsWithName(ConceptName.valueOf(conceptName))));
    }
}
