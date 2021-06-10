package structural.abstractDocument;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public interface Document {
    void put(String key, Object value);

    Object get(String key);

    <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}

abstract class AbstractDocument implements Document {
    private final Map<String, Object> properties;

    public AbstractDocument(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public void put(String key, Object value) {
        properties.put(key, value);
    }

    @Override
    public Object get(String key) {
        return properties.get(key);
    }

    @Override
    public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
        return Stream.ofNullable(get(key))
                .filter(Objects::nonNull)
                .map(el -> (List<Map<String, Object>>) el)
                .findAny()
                .stream()
                .flatMap(Collection::stream)
                .map(constructor);
    }
}

enum Property {
    PARTS, TYPE, PRICE, MODEL
}

interface HasType extends Document {
    default Optional<String> getType() {
        return Optional.ofNullable(((String) get(Property.TYPE.toString())));
    }
}

interface HasPrice extends Document {
    default Optional<Number> getPrice() {
        return Optional.ofNullable(((Number) get(Property.PRICE.toString())));
    }
}

interface HasParts extends Document {
    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}

interface HasModel extends Document {
    default Optional<String> getModel() {
        return Optional.ofNullable(((String) get(Property.MODEL.toString())));
    }
}

class Part extends AbstractDocument implements HasModel, HasPrice, HasType {
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}



