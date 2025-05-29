package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: ThreadPoolsTest
 * Package: ThreadPool
 * Dscription:创建线程池的方法种类
 * 1. newFixedThreadPool(int nThreads)
 * 特点：固定线程数，使用无界队列 LinkedBlockingQueue
 * 适用场景：任务量稳定且并发可控的场景（如 Web 服务请求处理）
 * 风险：队列无界可能导致内存溢出（OOM）
 *
 * 2. newSingleThreadExecutor()
 * 特点：单线程顺序执行任务，保证任务顺序性
 * 适用场景：需严格顺序执行的场景（如事务处理）
 * 风险：单线程易成为性能瓶颈
 *
 * 3. newCachedThreadPool()
 * 特点：动态扩展线程数（上限 Integer.MAX_VALUE），空闲线程 60 秒回收
 * 适用场景：短期高并发任务（如 HTTP 请求）
 * 风险：无界线程数可能导致系统资源耗尽
 * 4. newScheduledThreadPool(int corePoolSize)
 * 特点：支持定时/周期性任务，使用 DelayedWorkQueue
 * 适用场景：定时任务调度（如缓存刷新）
 * 风险：队列无界可能堆积任务
 * 5. newWorkStealingPool(int parallelism)
 * 特点：基于 ForkJoinPool 实现，任务窃取算法
 * 适用场景：CPU 密集型并行计算（如数据处理）
 * 风险：任务分配不均可能影响效率
 *
 *线程池类型                 线程数控制   任务队列    适用场景       风险提示
 * FixedThreadPool         固定         无界队列    稳定并发任务    队列堆积导致 OOM
 * CachedThreadPool        动态扩展     同步队列    短期高并发任务    线程数无界耗尽资源
 * ScheduledThreadPool    固定         延迟队列     定时/周期性任务    队列堆积导致延迟增加
 * WorkStealingPool        动态         任务窃取队列    并行计算    任务分配不均影响效率
 * 自定义 ThreadPoolExecutor  完全可控    按需选择队列    生产环境核心方案    需合理配置参数
 *
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 17:14
 */
public class ThreadPoolsTest {
    public static void main(String[] args) {
        //固定线程数，使用无界队列
        ExecutorService es1 = Executors.newFixedThreadPool(10);
        //单线程顺序执行任务，保证任务顺序性;线程池内只有一个核心线程，每个任务都要等前一个任务执行完才能进入
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        //动态扩展线程数（上限 Integer.MAX_VALUE），空闲线程 60 秒回收，速度最快
        ExecutorService es3 = Executors.newCachedThreadPool();
        //支持定时/周期性任务，使用 DelayedWorkQueue
        ExecutorService es4 = Executors.newScheduledThreadPool(5);
        //基于 ForkJoinPool 实现，任务窃取算法，大概就是如果这个线程池的任务都做完了，会自己从其他线程池拿任务来做
        ExecutorService es5 = Executors.newWorkStealingPool();

        ExecutorService es = es5;

        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"===>正在执行");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        es.shutdown();
    }
}
