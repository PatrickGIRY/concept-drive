package tools.concept.drive.framework;

import java.util.HashMap;
import java.util.Map;

public class Bus {
    private final HandlerRegister handlers;

    public static Bus.Builder builder() {
        return new Builder();
    }

    private Bus(HandlerRegister handlers) {
        this.handlers = handlers;
    }

    public <M extends Message<T>, T> void dispatch(M message) {
        handlers.forTypeOf(message).handle(message);
    }

    public static class Builder {
        private final HandlerRegister handlers = new HandlerRegister();

        private Builder() {
        }

        public <M extends Message<T>, T> Builder when(Class<M> messageType, Handler<M, T> handler) {
            handlers.register(messageType, handler);
            return this;
        }

        public Bus build() {
            return new Bus(handlers);
        }
    }

    private static class HandlerRegister {
        private final Map<Class<? extends Message<?>>, Handler<? extends Message<?>, ?>> handlers = new HashMap<>();

        private HandlerRegister() {
        }

        @SuppressWarnings("unchecked")
        private <M extends Message<T>, T> Handler<M, T> forTypeOf(M message) {
            return (Handler<M, T>) handlers.get(message.getClass());
        }

        private <M extends Message<T>, T> void register(Class<M> messageType, Handler<M, T> handler) {
            handlers.put(messageType, handler);
        }
    }
}
