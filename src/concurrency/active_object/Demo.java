package concurrency.active_object;

/**
 * The active object design pattern decouples method execution from method invocation for objects that each reside in their thread of control.
 * The goal is to introduce concurrency, by using asynchronous method invocation and a scheduler for handling requests.
 *
 * The class that implements the active object pattern will contain a self-synchronization mechanism without using 'synchronized' methods.
 */

public class Demo {
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 5; i++) {
                Orc creature = new Orc(Orc.class.getSimpleName() + " : " +i);
                creature.eat();
                creature.roam();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Runtime.getRuntime().exit(0);
    }
}
