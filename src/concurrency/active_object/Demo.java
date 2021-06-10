package concurrency.active_object;

public class Demo {
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 5; i++) {
                Orc creature = new Orc(Orc.class.getSimpleName().toString() + " : " +i);
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
