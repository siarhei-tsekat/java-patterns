package structural.ammbassador;

public class ServiceAmbassador implements RemoteServiceInterface {
    private static final int RETRIES = 3;
    private static final int DELAY_MS = 3000;
    public static final long FAILURE = -1;

    @Override
    public long doRemoteFunction(int value) {
        return safeCall(value);
    }

    private long safeCall(int value) {
        int retriesDone = 0;
        long res = FAILURE;

        for (int i = 0; i < RETRIES; i++) {
            if (retriesDone >= RETRIES) {
                return FAILURE;
            }

            if ((res = checkLatency(value)) == FAILURE) {
                System.out.println("Failed to reach remote: (" + (i + 1) + ")");
                retriesDone++;

                try {
                    Thread.sleep(DELAY_MS);
                } catch (InterruptedException e) {
                    System.out.println("Thread sleep interrupted");
                }
            } else {
                break;
            }
        }
        return res;
    }

    private long checkLatency(int value) {
        long startTime = System.currentTimeMillis();
        long res = RemoteService.getInstance().doRemoteFunction(value);
        long timeTaken = System.currentTimeMillis() - startTime;

        System.out.println("Time taken (ms): " + timeTaken);
        return res;
    }
}
