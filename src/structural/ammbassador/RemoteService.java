package structural.ammbassador;

public class RemoteService implements RemoteServiceInterface {
    private static RemoteService remoteService = null;

    public static synchronized RemoteService getInstance() {
        if (remoteService == null) {
            remoteService = new RemoteService();
        }
        return remoteService;
    }

    private RemoteService() {
    }

    @Override
    public long doRemoteFunction(int value) {
        long waitTime = (long) Math.floor(Math.random() + 1000);
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            System.out.println("Thread sleep interrupted");
        }
        return waitTime >= 200 ? value * 10 : -1;
    }
}
