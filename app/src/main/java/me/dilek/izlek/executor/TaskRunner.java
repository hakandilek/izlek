package me.dilek.izlek.executor;

import org.androidannotations.annotations.EBean;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A task Runner based on a thread pool
 *
 * @author Hakan Dilek on 10.04.2015.
 */
@EBean(scope = EBean.Scope.Singleton)
public class TaskRunner {
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();
    private final ThreadPoolExecutor threadPoolExecutor;

    public TaskRunner() {
        int corePoolSize = CORE_POOL_SIZE;
        int maxPoolSize = MAX_POOL_SIZE;
        int keepAliveTime = KEEP_ALIVE_TIME;
        TimeUnit timeUnit = TIME_UNIT;
        BlockingQueue<Runnable> workQueue = WORK_QUEUE;
        threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, timeUnit, workQueue);
    }

    public void run(final Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task to execute can't be null");
        }
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                task.run();
            }
        });
    }
}
