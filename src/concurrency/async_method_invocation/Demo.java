package concurrency.async_method_invocation;

import java.util.concurrent.Callable;

public class Demo {
    public static void main(String[] args) throws Exception {
        ThreadAsyncExecutor asyncExecutor = new ThreadAsyncExecutor();

        AsyncResult<Integer> asyncResult1 = asyncExecutor.startProcess(lazyVal(10, 500));
        AsyncResult<String> asyncResult2 = asyncExecutor.startProcess(lazyVal("test", 300));
        AsyncResult<Long> asyncResult3 = asyncExecutor.startProcess(lazyVal(50L, 700));
        AsyncResult<Integer> asyncResult4 = asyncExecutor.startProcess(lazyVal(20, 400));

//        callback("Deploying lunar rover");

        AsyncResult<String> asyncResult5 = asyncExecutor.startProcess(lazyVal("callback", 600), callback("Deploying lunar rover"));

        Thread.sleep(350);

        System.out.println("Mission command is sipping coffee");

        Integer result1 = asyncExecutor.endProcess(asyncResult1);
        String result2 = asyncExecutor.endProcess(asyncResult2);
        Long result3 = asyncExecutor.endProcess(asyncResult3);
        asyncResult4.await();
        asyncResult5.await();

        System.out.println("Space rocket: " + result1 + " launch complete");
        System.out.println("Space rocket: " + result2 + " launch complete");
        System.out.println("Space rocket: " + result3 + " launch complete");


    }

    private static <T> Callable<T> lazyVal(T value, long delayInMillis) {
        return () -> {
            Thread.sleep(delayInMillis);
            System.out.println("Space rocket " + value + " launched successfully");
            return value;
        };
    }

    private static <T> AsyncCallback<T> callback(String name) {
        return (value, ex) -> {
            if (ex.isPresent()) {
                System.out.println(name + " failed: " + ex.map(Exception::getMessage).orElse(""));
            } else {
                System.out.println(name + "" + value);
            }
        };
    }
}
