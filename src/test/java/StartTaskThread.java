import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Saul on 19/06/2017.
 */
public class StartTaskThread implements Runnable {
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private int i;

    public StartTaskThread(ThreadPoolTaskExecutor threadPoolTaskExecutor, int i) {
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
        this.i = i;
    }

    @Override
    public synchronized void run() {

    }
}
