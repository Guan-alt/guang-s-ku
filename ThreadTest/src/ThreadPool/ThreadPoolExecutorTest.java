package ThreadPool;

import java.util.concurrent.*;

/**
 * ClassName: ThreadPoolExecutor
 * Package: ThreadPool
 * Dscription:自定义线程池
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 17:05
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(
                3,//核心线程数
                5,//最大线程数，非核心线程数=5-3=2
                1L,//非核心线程空闲不被销毁的最大时间
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(3),//等待队列长度
                Executors.defaultThreadFactory(),//创建线程池的工厂
                new ThreadPoolExecutor.AbortPolicy()//拒绝策略
        );

        //测试给线程池分配任务
        for (int i = 0; i < 5; i++) {
            //用submit方法提交任务，也可以用execute方法提交（区别：submit方法提交任务有返回值，execute没有）
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"===>执行任务");
                }
            });

        }
        //销毁线程池，不销毁程序会一直运行
        es.shutdown();
    }
}
