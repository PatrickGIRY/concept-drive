package tools.concept.drive.framework;

public interface Handler <M extends Message<T>, T> {

    void handle(M message);
}
