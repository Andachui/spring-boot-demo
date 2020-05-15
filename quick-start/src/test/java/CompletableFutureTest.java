import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    private static List<String> nums = new ArrayList<String>();

    static {
        for (int i = 0; i < 10; i++) {
            nums.add("" + i);
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<CompletableFuture<String>> resultFuture = nums.stream()
                .map(num -> CompletableFuture
                        .supplyAsync(() -> {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return "" + num + " is end";
                        }, executor))
                .collect(Collectors.toList());
        CompletableFuture<String>[] resultFutureArray = resultFuture.toArray(new CompletableFuture[resultFuture.size()]);
        CompletableFuture<Void> allDone = CompletableFuture.allOf(resultFutureArray);
        resultFuture.stream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });


    }
}
