package concurrency.active_object;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ActiveCreature {
    private final BlockingQueue<Runnable> requests;

    private final String name;

    public ActiveCreature(String name) {
        this.name = name;
        this.requests = new LinkedBlockingQueue<>();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    requests.take().run();
                } catch (InterruptedException e) {
                    System.out.println("ERROR: Thread id [" + Thread.currentThread().getId() + "] In : [" + name + "]\n " + e.getMessage());
                }
            }
        });

        thread.start();
    }


    public void eat() throws InterruptedException {
        requests.put(() -> {
            System.out.println(name() + " is eating!");
            System.out.println(name() + " has finished eating!");
        });
    }

    public void roam() throws InterruptedException {
        requests.put(() -> {
            System.out.println(name() + " has started to roam and the wastelands.");
        });
    }

    private String name() {
        return name;
    }
}
