package structural.abstractDocument;

import java.util.List;
import java.util.Map;


/**
 * Intent
 * Use dynamic properties and achieve flexibility of untyped languages while keeping type-safety.
 *
 * Explanation
 * The Abstract Document pattern enables handling additional, non-static properties. This pattern uses concept of traits
 * to enable type safety and separate properties of different classes into set of interfaces.
 *
 * Real world example
 *
 * Consider a car that consists of multiple parts. However we don't know if the specific car really has all the parts,
 * or just some of them. Our cars are dynamic and extremely flexible.
 *
 * In plain words
 *
 * Abstract Document pattern allows attaching properties to objects without them knowing about it.
 *
 * Wikipedia says
 *
 * An object-oriented structural design pattern for organizing objects in loosely typed key-value stores and exposing
 * the data using typed views. The purpose of the pattern is to achieve a high degree of flexibility between components
 * in a strongly typed language where new properties can be added to the object-tree on the fly, without losing the support of type-safety.
 * The pattern makes use of traits to separate different properties of a class into different interfaces.
 *
 *
 * https://martinfowler.com/apsupp/properties.pdf
 */

public class Demo {
    public static void main(String[] args) {
        var wheelProps = Map.of(
                Property.TYPE.toString(), "wheel",
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 100L);

        var doorProps = Map.of(
                Property.TYPE.toString(), "door",
                Property.MODEL.toString(), "Lambo",
                Property.PRICE.toString(), 300L);

        var carProps = Map.of(
                Property.MODEL.toString(), "15C",
                Property.PRICE.toString(), 1000L,
                Property.PARTS.toString(), List.of(wheelProps, doorProps));


        Car car = new Car(carProps);

        car.getParts().
                forEach(p -> System.out.println("type: " + p.getType().orElse(null) + " price: " + p.getPrice().orElse(null) + " model: " + p.getModel().orElse(null)));

    }
}
