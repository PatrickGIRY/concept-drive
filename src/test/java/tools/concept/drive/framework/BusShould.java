package tools.concept.drive.framework;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BusShould {

    @Test
    void dispatch_a_message_to_a_specific_handler() {

        SayHelloResponseHandler sayHelloResponseHandler = new SayHelloResponseHandler();
        var outputBus = Bus.builder().when(SayHelloResponse.class, sayHelloResponseHandler).build();
        var inputBus = Bus.builder().when(SayHello.class, message -> outputBus.dispatch(new SayHelloResponse(message.payload())))
                .build();

        inputBus.dispatch(new SayHello());

        assertThat(sayHelloResponseHandler.message).isNotNull();
        assertThat(sayHelloResponseHandler.message.payload()).isEqualTo("Hello");

    }


    private static class SayHello implements Message<String> {
        @Override
        public String payload() {
            return "Hello";
        }
    }


    private static class SayHelloResponse implements Message<String> {
        private final String hello;

        public SayHelloResponse(String hello) {
            this.hello = hello;
        }

        @Override
        public String payload() {
            return hello;
        }
    }

    private static class SayHelloResponseHandler implements Handler<SayHelloResponse, String> {

        private SayHelloResponse message;

        @Override
        public void handle(SayHelloResponse message) {

            this.message = message;
        }
    }
}