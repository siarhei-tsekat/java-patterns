package concurrency.balking;

import java.util.concurrent.TimeUnit;

public class WashingMachine {
    private final DelayProvider delayProvider;
    private WashingMachineState washingMachineState;

    public WashingMachine() {
        this((interval, timeUnit, task) -> {

            try {
                Thread.sleep(timeUnit.toMillis(interval));
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
                Thread.currentThread().interrupt();
            }

            task.run();

        });
    }

    public WashingMachine(DelayProvider delayProvider) {
        this.delayProvider = delayProvider;
        this.washingMachineState = WashingMachineState.ENABLED;
    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    public void wash() {
        synchronized (this) {
            WashingMachineState washingMachineState = getWashingMachineState();

            System.out.println(Thread.currentThread().getId() + ": Actual machine state: " + washingMachineState);

            if (washingMachineState == WashingMachineState.WASHING) {
                System.out.println("Can not wash if the machine has been already washing");
                return;
            }

            this.washingMachineState = WashingMachineState.WASHING;

            System.out.println(Thread.currentThread().getId() + " Doing the washing");
            this.delayProvider.executeAfterDelay(50, TimeUnit.MILLISECONDS, this::endOfWashing);
        }
    }

    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        System.out.println(Thread.currentThread().getId() + " Washing completed");
    }
}
