import java.util.concurrent.*;

public class ThreadPool {
    //创建基本线程池
    static ExecutorService threadPoolExecutor;
    static {
        //创建基本线程池
        threadPoolExecutor = new ThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(25));
        //可重用固定线程数
//        threadPoolExecutor = Executors.newFixedThreadPool(5);
        //单个核线的fixed
//        threadPoolExecutor = Executors.newSingleThreadExecutor();
        //按需创建
//        threadPoolExecutor = Executors.newCachedThreadPool();
        //定时延时执行
//        threadPoolExecutor = Executors.newScheduledThreadPool(3);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            final int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //延迟线程池，取消等待时间。
                        if (!(threadPoolExecutor instanceof ScheduledExecutorService)) {
                            Thread.sleep(3000);
                        }
                        System.out.println("run : "+finalI+"  当前线程："+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            if (threadPoolExecutor instanceof ScheduledExecutorService) {
                //延迟5秒执行
                ((ScheduledExecutorService) threadPoolExecutor).schedule(runnable, 5, TimeUnit.SECONDS);
            } else {
                threadPoolExecutor.execute(runnable);
            }
        }

    }
}
