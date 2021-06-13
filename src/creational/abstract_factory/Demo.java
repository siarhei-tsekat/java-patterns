package creational.abstract_factory;

/**
 * Intent
 * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
 *
 * Applicability
 * Use the Abstract Factory pattern when
 *
 * The system should be independent of how its products are created, composed, and represented
 * The system should be configured with one of the multiple families of products
 * The family of related product objects is designed to be used together, and you need to enforce this constraint
 * You want to provide a class library of products, and you want to reveal just their interfaces, not their implementations
 * The lifetime of the dependency is conceptually shorter than the lifetime of the consumer.
 * You need a run-time value to construct a particular dependency
 * You want to decide which product to call from a family at runtime.
 * You need to supply one or more parameters only known at run-time before you can resolve a dependency.
 * When you need consistency among products
 * You don’t want to change existing code when adding new products or families of products to the program.

 * Consequences:
 * While the pattern is great when creating predefined objects, adding the new ones might be challenging.
 * The code becomes more complicated than it should be since a lot of new interfaces and classes are introduced along with the pattern.
 *
 */
public class Demo {
    public static void main(String[] args) {
        KingdomFactory kingdomFactory = FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF);
        System.out.println(kingdomFactory.createCastle().getDescription());
        System.out.println(kingdomFactory.createArmy().getDescription());
        System.out.println(kingdomFactory.createKing().getDescription());


        KingdomFactory kingdomFactoryOrc = FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC);
        System.out.println(kingdomFactoryOrc.createCastle().getDescription());
        System.out.println(kingdomFactoryOrc.createArmy().getDescription());
        System.out.println(kingdomFactoryOrc.createKing().getDescription());

    }
}
